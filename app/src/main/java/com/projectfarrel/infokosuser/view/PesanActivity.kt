package com.projectfarrel.infokosuser.view

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.lifecycle.ViewModelProvider
import com.projectfarrel.infokosuser.R
import com.projectfarrel.infokosuser.databinding.ActivityMapsBinding
import com.projectfarrel.infokosuser.databinding.ActivityPesanBinding
import com.projectfarrel.infokosuser.viewmodel.ViewModelPesan

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class PesanActivity : AppCompatActivity() {
    lateinit var binding : ActivityPesanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPesanBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val nKos = intent.getStringExtra("nama")
        binding.etNamaKos.setText(nKos)



        val kalender = Calendar.getInstance()

        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            kalender.set(Calendar.YEAR, year)
            kalender.set(Calendar.MONTH, month)
            kalender.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLable(kalender)
        }
        binding.btntglPesan.setOnClickListener {
            DatePickerDialog(this,datePicker,kalender.get(Calendar.YEAR),kalender.get(Calendar.MONTH),
                kalender.get(Calendar.DAY_OF_MONTH)).show()
        }
        binding.btnPesan.setOnClickListener {
            val nama = binding.etNama.text.toString()
            val namaKos = binding.etNamaKos.text.toString()
            val noHp = binding.etAddNoHpE.text.toString()
            val tgl = binding.etTglPesan.text.toString()
            val noKamar = binding.etNoKamar.text.toString()
            val status = binding.status.text.toString()
            binding.status.isGone = false


            postPesan(nama,namaKos,noHp,noKamar,tgl,status)
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            Toast.makeText(this,"Pesan sukses", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateLable(kalender: Calendar) {
        val myformat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myformat, Locale.UK)
        binding.etTglPesan.setText(sdf.format(kalender.time))

    }


    fun postPesan(nama: String,
                  namaKos: String,
                  noHp: String,
                  noKamar: String,
                  tglpesan: String,
                  status: String){
        val viewModel = ViewModelProvider(this).get(ViewModelPesan::class.java)
        viewModel.callPostPesanKos(nama,namaKos,noHp,noKamar,tglpesan,status)
        viewModel.postPesanKos().observe(this,{
            if (it != null){
                Toast.makeText(this,"add data sukses", Toast.LENGTH_SHORT).show()
            }
        })
        finish()
    }
}
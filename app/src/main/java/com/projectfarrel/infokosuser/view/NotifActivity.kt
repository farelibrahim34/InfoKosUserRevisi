package com.projectfarrel.infokosuser.view

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.projectfarrel.infokosuser.R
import com.projectfarrel.infokosuser.adapter.AdapterNotif
import com.projectfarrel.infokosuser.databinding.ActivityNotifBinding
import com.projectfarrel.infokosuser.viewmodel.ViewModelPesan

import java.util.concurrent.TimeUnit

class NotifActivity : AppCompatActivity() {
    lateinit var binding : ActivityNotifBinding
    private val CHANNEL_ID = "chanel_id_example_01"
    private val notificationId = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notif)
        binding = ActivityNotifBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getNotif()

        binding.ivBackDetail.setOnClickListener{
            startActivity(Intent(this,HomeActivity::class.java))
        }

    }


    fun getNotif(){
        val viewModel = ViewModelProvider(this).get(ViewModelPesan::class.java)
        viewModel.getPesanKos().observe(this){
            if (it != null){
                binding.rvPesan.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
                val adapter = AdapterNotif(it)
                binding.rvPesan.adapter = adapter

            }
        }
        viewModel.callApiPesanKos()
    }




}
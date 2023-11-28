package com.projectfarrel.infokosuser.adapter

import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.projectfarrel.infokosuser.databinding.ItemPesanBinding
import com.projectfarrel.infokosuser.model.ResponsePesanKosItem


class AdapterNotif(val listNotifikasi: List<ResponsePesanKosItem>):RecyclerView.Adapter<AdapterNotif.ViewHolder>(){

    class ViewHolder(var binding: ItemPesanBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemPesanBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listNotifikasi.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.txtNamaKos.text = listNotifikasi[position].namaKos
        holder.binding.txtOrderBy.text = listNotifikasi[position].nama
        holder.binding.txtNoHp.text = "Nomor Hp : "+listNotifikasi[position].noHp
        holder.binding.txtTglOrder.text = listNotifikasi[position].tglpesan
        holder.binding.txtNoKamar.text = "Nomor Kamar : "+listNotifikasi[position].noKamar
        holder.binding.txtStatus.text = listNotifikasi[position].status

    }

}
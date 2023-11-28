package com.projectfarrel.infokosuser.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.projectfarrel.infokosuser.model.PesanKos
import com.projectfarrel.infokosuser.model.ResponsePesanKos
import com.projectfarrel.infokosuser.network.ApiClient
import com.projectfarrel.infokosuser.network.ApiInterface

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


public class ViewModelPesan: ViewModel() {
    lateinit var postLdPesanKos : MutableLiveData<ResponsePesanKos?>
    init {
        postLdPesanKos = MutableLiveData()

    }
    fun postPesanKos(): MutableLiveData<ResponsePesanKos?>{
        return postLdPesanKos
    }
    fun callPostPesanKos(nama: String,
                         namaKos: String,
                         noHp: String,
                         noKamar: String,
                         tglpesan: String,
                         status: String){
        ApiClient.instanceDua.addPesan(PesanKos(nama,namaKos,noHp,tglpesan,noKamar,status))
            .enqueue(object : Callback<ResponsePesanKos>{
                override fun onResponse(
                    call: Call<ResponsePesanKos>,
                    response: Response<ResponsePesanKos>
                ) {
                    if(response.isSuccessful){
                        postLdPesanKos.postValue(response.body())
                    }else{
                        postLdPesanKos.postValue(null)
                    }
                }

                override fun onFailure(call: Call<ResponsePesanKos>, t: Throwable) {
                    postLdPesanKos.postValue(null)
                }

            })
    }
}
package com.projectfarrel.infokosuser.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.projectfarrel.infokosuser.model.PesanKos
import com.projectfarrel.infokosuser.model.ResponsePesanKos
import com.projectfarrel.infokosuser.model.ResponsePesanKosItem
import com.projectfarrel.infokosuser.network.ApiClient
import com.projectfarrel.infokosuser.network.ApiInterface

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


public class ViewModelPesan: ViewModel() {
    lateinit var postLdPesanKos : MutableLiveData<ResponsePesanKos?>
    lateinit var ldPesanKos: MutableLiveData<List<ResponsePesanKosItem>>
    init {
        postLdPesanKos = MutableLiveData()
        ldPesanKos = MutableLiveData()

    }
    fun getPesanKos():MutableLiveData<List<ResponsePesanKosItem>>{
        return ldPesanKos
    }
    fun postPesanKos(): MutableLiveData<ResponsePesanKos?>{
        return postLdPesanKos
    }
    fun callApiPesanKos(){
        ApiClient.instanceDua.getAllPesanKos()
            .enqueue(object:Callback<List<ResponsePesanKosItem>>{
                override fun onResponse(
                    call: Call<List<ResponsePesanKosItem>>,
                    response: Response<List<ResponsePesanKosItem>>
                ) {
                    if (response.isSuccessful){
                        ldPesanKos.postValue(response.body())
                    }else{
                        ldPesanKos.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<ResponsePesanKosItem>>, t: Throwable) {
                    ldPesanKos.postValue(null)
                }

            })
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
package com.projectfarrel.infokosuser.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.projectfarrel.infokosuser.model.ResponseDataKosItem
import com.projectfarrel.infokosuser.model.ResponsePesanKos
import com.projectfarrel.infokosuser.network.ApiClient
import com.projectfarrel.infokosuser.network.ApiInterface

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class ViewModelDataKos: ViewModel() {
    lateinit var ldDataKos : MutableLiveData<List<ResponseDataKosItem>>

    lateinit var ldDataKosPi : MutableLiveData<List<ResponseDataKosItem>>
    lateinit var postLdPesanKos : MutableLiveData<ResponsePesanKos?>

    init {
        ldDataKos = MutableLiveData()

        ldDataKosPi = MutableLiveData()
        postLdPesanKos = MutableLiveData()

    }
    fun getDataKos(): MutableLiveData<List<ResponseDataKosItem>> {
        return ldDataKos
    }

    fun getDataKosPi(): MutableLiveData<List<ResponseDataKosItem>> {
        return ldDataKosPi
    }

    fun postPesanKos(): MutableLiveData<ResponsePesanKos?>{
        return postLdPesanKos
    }


    fun callApiDataKos(){
        ApiClient.instance.getAllDataKos()
            .enqueue(object : Callback<List<ResponseDataKosItem>> {
                override fun onResponse(
                    call: Call<List<ResponseDataKosItem>>,
                    response: Response<List<ResponseDataKosItem>>
                ) {
                    if (response.isSuccessful){
                        ldDataKos.postValue(response.body())
                    }else{
                        ldDataKos.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<ResponseDataKosItem>>, t: Throwable) {
                    ldDataKos.postValue(null)
                }

            })
    }
    fun callApiDataKosPi(){
        ApiClient.instance.getAllDataKosPutri()
            .enqueue(object  : Callback<List<ResponseDataKosItem>> {
                override fun onResponse(
                    call: Call<List<ResponseDataKosItem>>,
                    response: Response<List<ResponseDataKosItem>>
                ) {
                    if (response.isSuccessful){
                        ldDataKosPi.postValue(response.body())
                    }else{
                        ldDataKosPi.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<ResponseDataKosItem>>, t: Throwable) {
                    ldDataKosPi.postValue(null)
                }

            })
    }
}
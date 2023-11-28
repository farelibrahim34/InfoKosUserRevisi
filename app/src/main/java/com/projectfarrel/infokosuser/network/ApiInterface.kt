package com.projectfarrel.infokosuser.network

import com.projectfarrel.infokosuser.model.*
import com.projectfarrel.infokosuser.model.ResponseDataKosItem
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    //    Kos Putra
    @GET("datakos")
    fun getAllDataKos(): Call<List<ResponseDataKosItem>>

    //    Kos Putri
    @GET("datakosPutri")
    fun getAllDataKosPutri(): Call<List<ResponseDataKosItem>>
    @POST("pesanKos")
    fun addPesan(@Body request : PesanKos) :Call<ResponsePesanKos>
    @GET("pesanKos")
    fun getAllPesanKos(): Call<List<ResponsePesanKosItem>>

}
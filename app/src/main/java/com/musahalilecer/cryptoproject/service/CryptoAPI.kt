package com.musahalilecer.cryptoproject.service

import com.musahalilecer.cryptoproject.model.CryptoModel
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface CryptoAPI {

    //https://raw.githubusercontent.com/
    // atilsamancioglu/K21-JSONDataSet/master/crypto.json
  //  @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")
  //  fun getData(): Call<List<CryptoModel>>

    @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")
    fun getData(): Observable<List<CryptoModel>>
}
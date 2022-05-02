package com.example.apiapp.data.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header


interface TestApi {

    @GET("b/626f7f7b25069545a32c0210")
    fun getLocalWeather(@Header("secret-key") secretKey:String): Call<Weather>

}
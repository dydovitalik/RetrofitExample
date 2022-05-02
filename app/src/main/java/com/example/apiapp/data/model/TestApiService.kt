package com.example.apiapp.data.model


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class TestApiService {

    companion object {
        const val SECRET_KEY = "\$2b\$10\$0lBPy9LoWFzXksFcyju8cemLFcJKIJwcngqUBYcERr3b0f5.kPEbS"
    }

    var api: TestApi


    init {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.jsonbin.io/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(TestApi::class.java)
    }

    fun getLocalWeather(callback: WeatherCallback) {
        api.getLocalWeather(SECRET_KEY).enqueue(object : Callback<Weather> {
            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                if (response.code() == 200 && response.body() != null)
                    callback.onSuccess(response.body()!!)
                else
                    callback.onFailure()
            }

            override fun onFailure(call: Call<Weather>, t:Throwable){
                callback.onFailure()
            }
        })
    }

    interface WeatherCallback{
        fun onSuccess(weather: Weather)
        fun onFailure()
    }

}
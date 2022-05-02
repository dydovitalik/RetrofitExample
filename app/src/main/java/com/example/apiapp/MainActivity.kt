package com.example.apiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.example.apiapp.data.model.TestApi
import com.example.apiapp.data.model.TestApiService
import com.example.apiapp.data.model.Weather

class MainActivity : AppCompatActivity() {

    lateinit var locationTv: TextView
    lateinit var temperatureTv: TextView
    lateinit var windTv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        locationTv = findViewById(R.id.locationTv)
        temperatureTv = findViewById(R.id.temperatureTv)
        windTv = findViewById(R.id.windTv)
    }

    override fun onResume() {
        super.onResume()
        loadData()
    }

    private fun loadData() {
        Log.d("API","loadData")
        val service = TestApiService()
        service.getLocalWeather(object : TestApiService.WeatherCallback{

            override fun onSuccess(weather: Weather) {
                displayWeather(weather)
            }

            override fun onFailure() {
                displayError()
            }
        })
    }

    private fun displayError(){
        Log.d("API", "error loading data")
        Toast.makeText(MainActivity@ this, "Failed to load data", Toast.LENGTH_LONG).show()
    }

    private fun displayWeather(weather: Weather){
        Log.d("API", "${weather.temperature}")
        Log.d("API", "${weather.location}")
        Log.d("API", "${weather.wind}")

        locationTv.setText("Weather at: ${weather.location?.name}")
        temperatureTv.setText("Temperature: ${weather.temperature} *C")
        windTv.setText("Wind: ${weather.wind?.speed} m/s ${weather.wind?.orientation!!}")
    }
}
package com.example.apiapp.data.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import com.example.apiapp.data.model.Wind

class Weather {
    @SerializedName("wind")
    @Expose
    var wind: Wind? = null

    @SerializedName("temperature")
    @Expose
    var temperature: String? = null

    @SerializedName("location")
    @Expose
    var location: Location? = null
}
package com.example.apiapp.data.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Location {
    @SerializedName("state")
    @Expose
    var state: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("lat")
    @Expose
    var lat: Double? = null

    @SerializedName("lon")
    @Expose
    var lon: Double? = null
}
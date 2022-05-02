package com.example.apiapp.data.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Wind {
    @SerializedName("speed")
    @Expose
    var speed: Int? = null

    @SerializedName("orientation")
    @Expose
    var orientation: String? = null
}
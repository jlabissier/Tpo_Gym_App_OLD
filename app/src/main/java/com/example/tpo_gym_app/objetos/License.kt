package com.example.tpo_gym_app.objetos
import com.google.gson.annotations.SerializedName


data class License (
    val id: Long? = null,

    @SerializedName("full_name")
    val fullName: String? = null,

    @SerializedName("short_name")
    val shortName: String? = null,

    val url: String? = null
)

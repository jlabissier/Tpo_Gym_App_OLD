package com.example.tpo_gym_app.objetos

import com.google.gson.annotations.SerializedName

data class Exercise (
    val id: Long? = null,
    val uuid: String? = null,
    val name: String? = null,

    @SerializedName("exercise_base")
    val exerciseBase: Long? = null,

    val description: String? = null,

    @SerializedName("creation_date")
    val creationDate: String? = null,

    val category: Long? = null,
    val muscles: ArrayList<Any>? = null,

    @SerializedName("muscles_secondary")
    val musclesSecondary: ArrayList<Any>? = null,


    val equipment: ArrayList<Any>? = null,
    val language: Long? = null,
    val license: Long? = null,

    @SerializedName("license_author")
    val licenseAuthor: String? = null,

    val variations: ArrayList<Any>? = null
)

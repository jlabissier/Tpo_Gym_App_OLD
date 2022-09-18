package com.example.tpo_gym_app.objetos

import com.google.gson.annotations.SerializedName

data class Exercise (
    val id: Long? = null,
    val uuid: String? = null,
    val aliases: List<Any?>? = null,
    val name: String? = null,
    val description: String? = null,
    val notes: List<Any?>? = null,

    @SerializedName("creation_date")
    val creationDate: String? = null,

    val language: Long? = null,
    val license: Long? = null,

    @SerializedName("license_author")
    val licenseAuthor: String? = null
)

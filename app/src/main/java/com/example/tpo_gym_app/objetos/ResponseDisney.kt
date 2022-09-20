package com.example.tpo_gym_app.objetos

import com.google.gson.annotations.SerializedName


data class ResponseDisney (
    val data: ArrayList<Personaje>,
    val count: Int,
    val totalPages: Int,
    val previousPage: String,
    val nextPage: String
)
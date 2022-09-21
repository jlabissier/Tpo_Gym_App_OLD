package com.example.tpo_gym_app.objetos

import com.google.gson.annotations.SerializedName


data class EjerciciosResponse (
        val count: Int? = null,
        val next: String? = null,
        val previous: String? = null,
        val results: ArrayList<Exercise>? = null,
)
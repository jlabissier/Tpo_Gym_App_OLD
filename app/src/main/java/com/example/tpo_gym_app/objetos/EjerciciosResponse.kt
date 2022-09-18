package com.example.tpo_gym_app.objetos

import com.google.gson.annotations.SerializedName


class EjerciciosResponse (
        val count: Int? = null,
        val next: String? = null,
        val previus: String? = null,
        val result: ArrayList<Exercise>? = null,
        )
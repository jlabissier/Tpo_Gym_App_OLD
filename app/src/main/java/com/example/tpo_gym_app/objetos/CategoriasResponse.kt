package com.example.tpo_gym_app.objetos


data class CategoriasResponse (
    val count: Int? = null,
    val next: String? = null,
    val previous: String? = null,
    val results: ArrayList<Category>? = null,
)
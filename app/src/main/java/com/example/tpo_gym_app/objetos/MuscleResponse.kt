package com.example.tpo_gym_app.objetos

data class MuscleResponse (
    val count: Int? = null,
    val next: String? = null,
    val previous: String? = null,
    val results: ArrayList<Muscle>? = null,
)

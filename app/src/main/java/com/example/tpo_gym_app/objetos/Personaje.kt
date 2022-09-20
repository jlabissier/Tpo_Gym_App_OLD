package com.example.tpo_gym_app.objetos

import com.google.gson.annotations.SerializedName

data class Personaje (

    val films: List<String>,
    val shortFilms: List<String>,
    val tvShows: List<String>,
    val videoGames: List<String>,
    val parkAttractions: List<String>,
    val allies: List<String>,
    val enemies: List<String>,

    @SerializedName("_id")
    val id: Long? = null,

    val name: String? = null,

    @SerializedName("imageUrl")
    val imageURL: String? = null,

    val url: String? = null
)

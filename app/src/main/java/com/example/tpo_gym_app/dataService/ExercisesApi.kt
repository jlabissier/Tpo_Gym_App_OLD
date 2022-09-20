package com.example.tpo_gym_app.dataService

import com.example.tpo_gym_app.objetos.EjerciciosResponse
import com.example.tpo_gym_app.objetos.Exercise
import com.example.tpo_gym_app.objetos.Personaje
import com.example.tpo_gym_app.objetos.ResponseDisney
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ExercisesApi {

    @GET("/characters")
    fun getPersonajes(
        //@Query("id") id:String
    ) : Call<ResponseDisney>

}
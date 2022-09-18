package com.example.tpo_gym_app.dataService

import com.example.tpo_gym_app.objetos.EjerciciosResponse
import com.example.tpo_gym_app.objetos.Exercise
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ExercisesApi {

    @GET("/api/v2/exercise/")
    fun getExersices(
        //@Query("id") id:String
    ) : Call<EjerciciosResponse>

}
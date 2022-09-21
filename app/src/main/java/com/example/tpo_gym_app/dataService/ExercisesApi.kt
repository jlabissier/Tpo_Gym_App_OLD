package com.example.tpo_gym_app.dataService

import com.example.tpo_gym_app.objetos.*
import retrofit2.Call
import retrofit2.http.GET

interface ExercisesApi {

    @GET("/api/v2/exercise?limit=500")
    fun getEjercicios(
        //@Query("id") id:String
    ) : Call<EjerciciosResponse>

    @GET("/api/v2/muscle?limit=500")
    fun getMuscles(
    ) : Call<MuscleResponse>

    @GET("/api/v2/exercisecategory")
    fun getCategorys(
    ): Call<CategoriasResponse>


}
package com.example.tpo_gym_app.dataService

import android.content.Context
import android.util.Log
import com.example.tpo_gym_app.objetos.EjerciciosResponse
import com.example.tpo_gym_app.objetos.Exercise
import com.example.tpo_gym_app.objetos.ExerciseBaseInfo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ApiServices {
    companion object{
        val BASE_URL = "https://wger.de/"
        suspend fun fetchdata(context: Context): ArrayList<Exercise> {

            val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val apiEndpoint = retrofit.create(ExercisesApi::class.java)
            var result = apiEndpoint.getExersices().execute()

            return if(result.isSuccessful){
                result.body()?.result!!
            }else{
                Log.e("debug","Error al obtener los Ejercicios")
                return ArrayList()
            }

        }

    }



}
package com.example.tpo_gym_app.dataService

import android.content.Context
import android.util.Log
import com.example.tpo_gym_app.objetos.Exercise
import com.example.tpo_gym_app.objetos.Personaje
import com.example.tpo_gym_app.objetos.ResponseDisney
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiServices {
    companion object{
        val BASE_URL = "https://api.disneyapi.dev/"
        suspend fun fetchdata(context: Context): ResponseDisney {

            val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val apiEndpoint = retrofit.create(ExercisesApi::class.java)
            var result = apiEndpoint.getPersonajes().execute()

            return if(result.isSuccessful){
                result.body()!!
            }else{
                Log.e("debug","Error al obtener los Ejercicios")
                val reponse = ResponseDisney(ArrayList<Personaje>(),0,0,"","")
                return reponse
            }

        }

    }



}
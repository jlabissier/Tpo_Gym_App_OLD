package com.example.tpo_gym_app.dataService

import android.content.Context
import com.example.tpo_gym_app.objetos.Exercise
import com.example.tpo_gym_app.objetos.Personaje
import com.example.tpo_gym_app.objetos.ResponseDisney

class RepositorioMain {
    // que corcho es esto.
    companion object {
        suspend fun fetchData(context: Context): ResponseDisney {
            return  ApiServices.fetchdata(context)
        }
    }
}
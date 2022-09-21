package com.example.tpo_gym_app.dataService

import android.content.Context
import com.example.tpo_gym_app.objetos.Category
import com.example.tpo_gym_app.objetos.Exercise
import com.example.tpo_gym_app.objetos.Muscle

class RepositorioMain {
    // que corcho es esto.
    companion object {
        suspend fun fetchEjercicios(context: Context): ArrayList<Exercise>? {
            return  ApiServices.fetchEjercicios(context)
        }

        suspend fun fetchCategorias(context: Context): ArrayList<Category>? {
            return ApiServices.fetchCategorias(context)
        }

        suspend fun fetchMusculos(context: Context): ArrayList<Muscle>? {
            return ApiServices.fetchMusculos(context)
        }


    }
}
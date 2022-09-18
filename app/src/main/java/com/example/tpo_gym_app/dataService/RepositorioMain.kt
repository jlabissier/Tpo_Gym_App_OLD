package com.example.tpo_gym_app.dataService

import android.content.Context
import com.example.tpo_gym_app.objetos.Exercise

class RepositorioMain {
    // que corcho es esto.
    companion object {
        suspend fun fetchData(context: Context): ArrayList<Exercise>{
            return  ApiServices.fetchdata(context)
        }
    }
}
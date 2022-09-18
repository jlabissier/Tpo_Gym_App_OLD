package com.example.tpo_gym_app.pantallas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.tpo_gym_app.R
import com.example.tpo_gym_app.dataService.RepositorioMain
import com.example.tpo_gym_app.objetos.Exercise
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class Home : AppCompatActivity() {
    private val coroutineContext: CoroutineContext = newSingleThreadContext("Main")
    private val scope = CoroutineScope(coroutineContext)
    private var ejercicios = ArrayList<Exercise>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnEjercicios = findViewById<Button>(R.id.BtnEjercicios)
        btnEjercicios.setOnClickListener{
            cambioPantallaEjercicios()
        }

        val btnFavoritos = findViewById<Button>(R.id.BtnFavoritos)
        btnFavoritos.setOnClickListener{
            cambioPantallaEjerciciosFavoritos()
        }
    }

    override fun onStart() {
        super.onStart()

        scope.launch{
            // TODO: Revisar todos los objtos. sos un vago julian.
            ejercicios = RepositorioMain.fetchData(this@Home)

            withContext(Dispatchers.Main){
                Log.d("debug","cantEjercicios: " + ejercicios.size)
            }
        }

    }





    fun cambioPantallaEjercicios(){
        // Cambiar a la pantalla de listado de ejercicios.
        // strar.listadoEjercicios("Ejercicios")
        var intent = Intent(this, ListadoEjercicios::class.java)
        intent.putExtra("Titulo","Ejercicios")
        startActivity(intent)
        finish()
    }

    fun cambioPantallaEjerciciosFavoritos(){
        // Cambiar a la pantalla de listado de ejercicios.
        // strar.listadoEjercicios("Favoritos", listaDeEjercicios.)
        var intent = Intent(this, ListadoEjercicios::class.java)
        intent.putExtra("Titulo","Favoritos")
        startActivity(intent)
        finish()
    }

}
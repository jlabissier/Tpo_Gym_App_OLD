package com.example.tpo_gym_app.pantallas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.tpo_gym_app.R

class Home : AppCompatActivity() {
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

    fun cambioPantallaEjercicios(){
        // Cambiar a la pantalla de listado de ejercicios.
        // strar.listadoEjercicios("Ejercicios")
        var intent = Intent(this, ListadoEjercicios::class.java)
        intent.putExtra("Titulo","Ejercicios")
        startActivity(intent)
    }

    fun cambioPantallaEjerciciosFavoritos(){
        // Cambiar a la pantalla de listado de ejercicios.
        // strar.listadoEjercicios("Favoritos", listaDeEjercicios.)
        var intent = Intent(this, ListadoEjercicios::class.java)
        intent.putExtra("Titulo","Favoritos")
        startActivity(intent)
    }

}
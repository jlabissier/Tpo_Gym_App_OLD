package com.example.tpo_gym_app.pantallas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.tpo_gym_app.R

class DescripcionEjercicio : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_descripcion_ejercicio)
    }


    override fun onStart() {
        super.onStart()
        var nombre = findViewById<TextView>(R.id.tvNombre)
        var musculo = findViewById<TextView>(R.id.tvMusculo)
        var descrip = findViewById<TextView>(R.id.tvDescrip)

        nombre.text = intent.extras?.getString("NombreEjercicio")
        musculo.text = intent.extras?.getString("NombreMusculo")
        descrip.text = intent.extras?.getString("Descripcion")



    }
}
package com.example.tpo_gym_app.pantallas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.tpo_gym_app.R

class Listado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_ejercicios)

        val btnHome = findViewById<Button>(R.id.BtnHome)
        btnHome.setOnClickListener {
            VolverAlHome()
        }
    }


    override fun onStart() {
        super.onStart()
        val titulo = intent.extras?.getString("Titulo")

        val TituloText = findViewById<TextView>(R.id.Titulo)
        TituloText.text = titulo;
        // como obtengo el titulo cuando inicio la activit
    }

    fun VolverAlHome(){
        var intent = Intent(this, Home::class.java)
        startActivity(intent)
        finish()
    }

}
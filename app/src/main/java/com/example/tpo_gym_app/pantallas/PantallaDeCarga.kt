package com.example.tpo_gym_app.pantallas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.tpo_gym_app.R

class PantallaDeCarga : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_de_carga)
    }


    override fun onStart() {
        super.onStart()

        var usuarioLogeado = true
        // validar si el usuario esta logeado
        // await de traerme todos los ejercicios.
        // se los mando a home.

        if (usuarioLogeado){
            //pantalla carga
            //busco lista favoritos.
            //pantalla home.
            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, Home::class.java)
                startActivity(intent)
                finish()
            },1000)
        }
        else{
            //pantalla login.
        }

    }
}
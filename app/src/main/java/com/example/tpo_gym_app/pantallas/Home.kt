package com.example.tpo_gym_app.pantallas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.tpo_gym_app.R
import com.example.tpo_gym_app.dataService.RepositorioMain
import com.example.tpo_gym_app.objetos.Category
import com.example.tpo_gym_app.objetos.Exercise
import com.example.tpo_gym_app.objetos.Muscle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class Home : AppCompatActivity() {
    private val coroutineContext: CoroutineContext = newSingleThreadContext("Main")
    private val scope = CoroutineScope(coroutineContext)
    private var ejercicios = ArrayList<Exercise>()
    private var musculos = ArrayList<Muscle>()
    private var categorias = ArrayList<Category>()

    private lateinit var fireBaseAuth: FirebaseAuth


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

        fireBaseAuth = FirebaseAuth.getInstance()

        checkUser()
        val btnLogout = findViewById<Button>(R.id.btnLogOut)
        btnLogout.setOnClickListener {
            fireBaseAuth.signOut()
            checkUser()
        }

    }

    private fun checkUser() {
        val firebaseUser = fireBaseAuth.currentUser
        if(firebaseUser == null){
            startActivity(Intent(this,Login::class.java))
        }

    }

    override fun onStart() {
        super.onStart()

        //cargarDatos()

    }


    fun cargarDatos(){
        // Ejercicios
        scope.launch{
            // TODO: Revisar todos los objtos. sos un vago julian.
            ejercicios = RepositorioMain.fetchEjercicios(this@Home)!!
            categorias = RepositorioMain.fetchCategorias(this@Home)!!
            musculos = RepositorioMain.fetchMusculos(this@Home)!!
            //var ejererciciosfavoritos = Repos.fetchFavoritos()

            withContext(Dispatchers.Main){
                //Log.d("debug","cant Personajes: " + personajes!!.data.size)
                Log.d("debug","Cant Ejercicios: " + (ejercicios!!.size ))
                Log.d("debug","Cant Categorias: " + (categorias!!.size ))
                Log.d("debug","Cant Musculos: " + (musculos!!.size ))

            }
        }

    }



    fun cambioPantallaEjercicios(){
        // Cambiar a la pantalla de listado de ejercicios.
        // strar.listadoEjercicios("Ejercicios")
        var intent = Intent(this, Listado::class.java)
        intent.putExtra("Titulo","Ejercicios")
        intent.putExtra("Ejercicios", ejercicios )
        intent.putExtra("Musculos",musculos)
        intent.putExtra("Categorias",categorias)

        startActivity(intent)
        finish()
    }

    fun cambioPantallaEjerciciosFavoritos(){
        // Cambiar a la pantalla de listado de ejercicios.
        var intent = Intent(this, Listado::class.java)
        intent.putExtra("Titulo","Favoritos")

        // todo: Lista ejercicios trae de firebase.
        intent.putExtra("Ejercicios",ejercicios)

        intent.putExtra("Musculos",musculos)
        intent.putExtra("Categorias",categorias)

        startActivity(intent)
        finish()
    }

}
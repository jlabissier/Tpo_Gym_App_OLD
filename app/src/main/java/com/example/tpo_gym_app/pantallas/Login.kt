package com.example.tpo_gym_app.pantallas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.tpo_gym_app.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import java.lang.Exception

class Login : AppCompatActivity() {
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var fireBaseAuth: FirebaseAuth
    private lateinit var btnLogin: SignInButton

    private val defaultClientId = "508539948395-6dvhhhncj32vbd9nn3t3kks2muhes2m4.apps.googleusercontent.com"

    private companion object {
        private const val RC_SIGN_IN = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        var gsioption = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this@Login,gsioption)

        fireBaseAuth = FirebaseAuth.getInstance()

        btnLogin = findViewById(R.id.btnLoginGoogle)
        btnLogin.setOnClickListener{
            val intent = googleSignInClient.signInIntent
            startActivityForResult(intent,RC_SIGN_IN)
        }

        checkUser()

    }

    fun checkUser() {
        val firebaseUser = fireBaseAuth.currentUser
        if (firebaseUser != null) {
            startActivity(Intent(this@Login, Home::class.java))
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 100){
            val accounTask = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = accounTask.getResult(ApiException::class.java)
                firebaseAutoAuthWihtGoogleAccount(account)
            }
            catch (e: Exception){
                Log.d("debug","onActivityResult: ${e.message}")
            }
        }
    }

    fun firebaseAutoAuthWihtGoogleAccount(account: GoogleSignInAccount? ){
        var credential = GoogleAuthProvider.getCredential(account!!.idToken,null)
        fireBaseAuth.signInWithCredential(credential)
            .addOnSuccessListener { authResult ->
                var firebaseUser = fireBaseAuth.currentUser
                var uid = firebaseUser!!.uid
                var email : String = firebaseUser!!.email!!
                Log.d("login", "Uid creado: $uid")
                Log.d("login", "Email creado: $email")


                if(authResult.additionalUserInfo!!.isNewUser){
                    Toast.makeText(this@Login,"Creando cuenta....", Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText(this@Login,"Cuenta existente....", Toast.LENGTH_LONG).show()
                }

                startActivity(Intent(this@Login, Home::class.java))
                finish()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this@Login,"Fallo el Login", Toast.LENGTH_LONG).show()
            }

    }
}
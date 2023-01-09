package com.flora.movies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import com.flora.movies.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    // Déclaration du binding en lateinit (fait le lien avec le layout XML)
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Init du binding
        binding = ActivityLoginBinding.inflate(layoutInflater)

        //Lien du binding avec ce qui est affiché à l'écran
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            val username = binding.usernameEditTextTextPersonName.text.toString()
            val password = binding.passwordEditTextTextPassword.text.toString()

            if (username == "kotlin" && password == "rocks") {
                Toast.makeText(this, "Login OK", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@LoginActivity, MovieListActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Username / password invalided", Toast.LENGTH_SHORT).show()
            }
        }

        /* Moi
        var username: String? = "jamesbond"
        username = username?.uppercase()
        username = username?.reversed()
        Log.i("LoginActivity", "$username" )*/

        //Correction
        var username: String? = "jamesbond"
        Log.i("LoginActivity", "username length=${username?.length}")
        Log.i("LoginActivity", "username uppercase + reversed=${username?.uppercase()?.reversed()}")

        val password = "password"
        Log.i("LoginActivity", "password length=${password.length}")
        Log.i("LoginActivity", "password uppercase + reversed=${password.uppercase().reversed()}")

    }
}
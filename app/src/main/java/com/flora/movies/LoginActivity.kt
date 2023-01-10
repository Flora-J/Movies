package com.flora.movies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.flora.movies.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    // Déclaration du binding en lateinit (fait le lien avec le layout XML)
    lateinit var binding: ActivityLoginBinding
    val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Init du binding
        binding = ActivityLoginBinding.inflate(layoutInflater)

        //Lien du binding avec ce qui est affiché à l'écran
        setContentView(binding.root)

        viewModel.stateLiveData.observe(this, Observer { state ->
            updateUi(state)
        })

        binding.loginButton.setOnClickListener {
            val username = binding.usernameEditTextTextPersonName.text.toString()
            val password = binding.passwordEditTextTextPassword.text.toString()

            viewModel.login(username, password)
        }
    }

    fun updateUi(state: LoginViewModelState) {
        when (state) {
            is LoginViewModelState.Failure -> {
                Toast.makeText(this, state.errorMessage, Toast.LENGTH_SHORT).show()
            }
            is LoginViewModelState.Success -> {
                Toast.makeText(this, "Login OK", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@LoginActivity, MovieListActivity::class.java)
                startActivity(intent)
            }
        }
    }
}

/*var username: String? = "jamesbond"
        Log.i("LoginActivity", "username length=${username?.length}")
        Log.i("LoginActivity", "username uppercase + reversed=${username?.uppercase()?.reversed()}")

        val password = "password"
        Log.i("LoginActivity", "password length=${password.length}")
        Log.i("LoginActivity", "password uppercase + reversed=${password.uppercase().reversed()}")*/
package com.flora.movies.features.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.Observer
import com.flora.movies.LoginViewModel
import com.flora.movies.LoginViewModelState
import com.flora.movies.features.movie.MovieListActivity
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

        binding.usernameEditTextTextPersonName.doAfterTextChanged {
            val username = binding.usernameEditTextTextPersonName.text.toString()
            val password = binding.passwordEditTextTextPassword.text.toString()

            viewModel.updateLogin(username, password)
        }

        binding.passwordEditTextTextPassword.doAfterTextChanged {
            val username = binding.usernameEditTextTextPersonName.text.toString()
            val password = binding.passwordEditTextTextPassword.text.toString()

            viewModel.updateLogin(username, password)
        }

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
            is LoginViewModelState.UpdateLogin -> {
                binding.loginButton.isEnabled = state.loginButtonEnabled
            }
            else -> {}
        }
    }
}
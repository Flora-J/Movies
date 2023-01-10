package com.flora.movies

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// Les différents état de l'écran LoginActivity
sealed class LoginViewModelState {
    class Success(val token: String) : LoginViewModelState()
    class Failure(val errorMessage: String) : LoginViewModelState()
}
class LoginViewModel : ViewModel() {
    val stateLiveData = MutableLiveData<LoginViewModelState>()

    fun login(username: String, password: String) {
        // Faire la vérification des credentials
        if (username == "kotlin" && password == "rocks") {
            // Si OK => produire state Success avec Token
            stateLiveData.value = LoginViewModelState.Success("23423423")
        } else {
            // Si KO => produire state Failure avec message d'erreur
            stateLiveData.value = LoginViewModelState.Failure("Login non valide")
        }
    }
}
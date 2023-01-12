package com.flora.movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// Les différents état de l'écran LoginActivity
sealed class LoginViewModelState {
    data class Success(val token: String) : LoginViewModelState()
    data class Failure(val errorMessage: String) : LoginViewModelState()
    data class UpdateLogin(val loginButtonEnabled: Boolean) : LoginViewModelState()
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

    fun updateLogin(username: String, password: String) {
        val isEnabled = username.isNotEmpty() && password.isNotEmpty()
        stateLiveData.value = LoginViewModelState.UpdateLogin(loginButtonEnabled = isEnabled)
    }
}
package com.flora.movies.features.user

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.flora.movies.User

private const val TAG = "UserViewModel"

class UserViewModel : ViewModel() {

    val userLiveData = MutableLiveData<User>()

    fun loadUser(id: Int) {
        Log.i(TAG, "loadUser: chargement depuis API, id=$id")
        // Requete HTTP, select BDD, etc.
        val user = User("Bob", "bob@acme.org")

        userLiveData.value = user
    }

}
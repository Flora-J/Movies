package com.flora.movies.features.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.flora.movies.databinding.ActivityUserBinding

private const val TAG = "UserActivity"


class UserActivity : AppCompatActivity() {

    lateinit var binding: ActivityUserBinding
    val viewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Je m'abonne sur les events du LiveData
        viewModel.userLiveData.observe(this, Observer { user ->
            Log.i(TAG, "onCreate: DANS LA CALLBACK LIVEDATA. user=$user")
            binding.nameTextView.text = user.username
        })

        // Je déclenche le chargement dans le ViewModel
        Log.i(TAG, "onCreate: JUSTE AVANT loadUser()")
        viewModel.loadUser(1)

    }
}
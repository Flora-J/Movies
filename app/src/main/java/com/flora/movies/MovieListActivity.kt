package com.flora.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.flora.movies.databinding.ActivityMovieListBinding

class MovieListActivity : AppCompatActivity() {

    lateinit var binding: ActivityMovieListBinding
    lateinit var adapter: MovieAdapter
    val viewModel: MovieListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = MovieAdapter(listOf())
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // Je m'abonne sur les events du LiveData
        viewModel.movieLiveData.observe(this, Observer { movies ->
            adapter.movies = movies
            adapter.notifyDataSetChanged()
        })

        // Je déclenche le chargement dans le ViewModel
        // déclencheur à la fin
        viewModel.loadMovies()
    }

}
package com.flora.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.flora.movies.databinding.ActivityMovieListBinding

class MovieListActivity : AppCompatActivity() {

    lateinit var binding: ActivityMovieListBinding
    lateinit var adapter: MovieAdapter

    val movies = listOf(
        Movie(1, "L'attaque de la moussaka géante", Genre.COMEDY, "1999", R.drawable.attaque_moussaka),
        Movie(1, "Avatar 2", Genre.SF, "2022", R.drawable.avatar_2),
        Movie(1, "Black Panther 2", Genre.ACTION, "2022", R.drawable.black_panther_2),
        Movie(1, "Interstellar", Genre.SF, "2014", R.drawable.interstellar),
        Movie(1, "L'attaque de la moussaka géante", Genre.COMEDY, "1999", R.drawable.attaque_moussaka),
        Movie(1, "Avatar 2", Genre.SF, "2022", R.drawable.avatar_2),
        Movie(1, "Black Panther 2", Genre.ACTION, "2022", R.drawable.black_panther_2),
        Movie(1, "Interstellar", Genre.SF, "2014", R.drawable.interstellar),
        Movie(1, "L'attaque de la moussaka géante", Genre.COMEDY, "1999", R.drawable.attaque_moussaka),
        Movie(1, "Avatar 2", Genre.SF, "2022", R.drawable.avatar_2),
        Movie(1, "Black Panther 2", Genre.ACTION, "2022", R.drawable.black_panther_2),
        Movie(1, "Interstellar", Genre.SF, "2014", R.drawable.interstellar),
        Movie(1, "L'attaque de la moussaka géante", Genre.COMEDY, "1999", R.drawable.attaque_moussaka),
        Movie(1, "Avatar 2", Genre.SF, "2022", R.drawable.avatar_2),
        Movie(1, "Black Panther 2", Genre.ACTION, "2022", R.drawable.black_panther_2),
        Movie(1, "Interstellar", Genre.SF, "2014", R.drawable.interstellar),
        Movie(1, "L'attaque de la moussaka géante", Genre.COMEDY, "1999", R.drawable.attaque_moussaka),
        Movie(1, "Avatar 2", Genre.SF, "2022", R.drawable.avatar_2),
        Movie(1, "Black Panther 2", Genre.ACTION, "2022", R.drawable.black_panther_2),
        Movie(1, "Interstellar", Genre.SF, "2014", R.drawable.interstellar),
        Movie(1, "L'attaque de la moussaka géante", Genre.COMEDY, "1999", R.drawable.attaque_moussaka),
        Movie(1, "Avatar 2", Genre.SF, "2022", R.drawable.avatar_2),
        Movie(1, "Black Panther 2", Genre.ACTION, "2022", R.drawable.black_panther_2),
        Movie(1, "Interstellar", Genre.SF, "2014", R.drawable.interstellar),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = MovieAdapter(movies)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }


}
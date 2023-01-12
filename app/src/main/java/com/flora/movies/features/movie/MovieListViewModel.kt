package com.flora.movies.features.movie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.flora.movies.Genre
import com.flora.movies.Movie
import com.flora.movies.R

class MovieListViewModel : ViewModel() {

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

    val movieLiveData = MutableLiveData<List<Movie>>()

    fun loadMovies() {
        // Requête HTTP, select BDD, etc...
        movieLiveData.value = movies
    }
}
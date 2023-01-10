package com.flora.movies

fun getGenreLabel (genre: Genre) : String {
    return when(genre) {
        Genre.ACTION -> "Action"
        Genre.SF -> "Science-Fiction"
        Genre.COMEDY -> "Comédie"
    }
}
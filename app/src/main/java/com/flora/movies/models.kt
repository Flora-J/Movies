package com.flora.movies

enum class Genre {
    SF,
    COMEDY
}

data class Movie (
    val id: Int,
    val title: String,
    val genre: Genre,
    val releaseDate: String
)
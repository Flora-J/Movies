package com.flora.movies

enum class Genre {
    ACTION,
    COMEDY,
    SF,
}

data class Movie (
    val id: Int,
    val title: String,
    val genre: Genre,
    val releaseDate: String,
    val posterId: Int,
)

data class User(val username: String, val email: String)
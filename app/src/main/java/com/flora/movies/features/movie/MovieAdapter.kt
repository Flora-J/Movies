package com.flora.movies.features.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.flora.movies.Movie
import com.flora.movies.databinding.ItemMovieBinding
import com.flora.movies.getGenreLabel

class MovieAdapter(var movies: List<Movie>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    // Fait le lien avec item_movie.xml
    class ViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(
        binding.root
    )

    // Est appelé 10/15x au 1er affichage de RecylcerView pour créer les ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.binding.posterImageView.setImageResource(movie.posterId)
        holder.binding.titleTextView.text = movie.title
        holder.binding.releaseDateTextView.text = movie.releaseDate
        holder.binding.genreLabelTextView.text = getGenreLabel(movie.genre)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

}
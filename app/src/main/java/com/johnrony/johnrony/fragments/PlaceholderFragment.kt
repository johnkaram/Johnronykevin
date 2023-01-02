package com.example.cinemaapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.cinemaapp.R
import com.example.cinemaapp.viewmodels.MovieViewModel
import kotlinx.android.synthetic.main.fragment_placeholder.*

class PlaceholderFragment : Fragment() {

    private lateinit var movieViewModel: MovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_placeholder, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        movieViewModel = activity?.run {
            ViewModelProvider(this).get(MovieViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
        movieViewModel.fetchMovies()
        movieViewModel.movies.observe(viewLifecycleOwner, { movies ->
            movies?.let {
                text_view.text = it[0].title
            }
        })
    }
}

package com.example.cinemaapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cinemaapp.R
import com.example.cinemaapp.adapters.MovieAdapter
import com.example.cinemaapp.models.Movie
import com.example.cinemaapp.viewmodels.MovieViewModel

class MovieFragment : Fragment() {

    private lateinit var movieViewModel: MovieViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie, container, false)
        recyclerView = view.findViewById(R.id.recycler_view)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        movieViewModel = activity?.run {
            ViewModelProvider(this).get(MovieViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
        adapter = MovieAdapter(activity)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity)
        movieViewModel.movies.observe(viewLifecycleOwner, { movies ->
            adapter.setMovies(movies)
        })
    }
}

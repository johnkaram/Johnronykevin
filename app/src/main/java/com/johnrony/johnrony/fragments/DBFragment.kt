package com.example.cinemaapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cinemaapp.R
import com.example.cinemaapp.adapters.ReviewAdapter
import com.example.cinemaapp.database.MovieDB
import com.example.cinemaapp.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DBFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var reviewAdapter: ReviewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_db, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.review_recycler_view)
        reviewAdapter = ReviewAdapter(requireContext())
        recyclerView.adapter = reviewAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        loadData()
    }

    private fun loadData() {
        CoroutineScope(Dispatchers.IO).launch {
            val movies = MovieDB.getInstance(requireContext()).movieDao().getAll()
            withContext(Dispatchers.Main) {
                reviewAdapter.submitList(movies)
            }
        }
    }
}

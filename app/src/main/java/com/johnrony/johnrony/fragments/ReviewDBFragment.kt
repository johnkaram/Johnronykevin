package com.example.cinemaapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.cinemaapp.R
import com.example.cinemaapp.viewmodels.ReviewViewModel
import kotlinx.android.synthetic.main.fragment_review_db.*

class ReviewDBFragment : Fragment() {

    private lateinit var reviewViewModel: ReviewViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_review_db, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        reviewViewModel = activity?.run {
            ViewModelProvider(this).get(ReviewViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
        reviewViewModel.fetchReviews()
        reviewViewModel.reviews.observe(viewLifecycleOwner, { reviews ->
            reviews?.let {
                text_view.text = it[0].review
            }
        }
    }
}
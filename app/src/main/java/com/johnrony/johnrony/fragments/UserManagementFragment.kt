package com.example.cinemaapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cinemaapp.R
import com.example.cinemaapp.viewmodels.UserViewModel
import kotlinx.android.synthetic.main.fragment_user_management.*

class UserManagementFragment : Fragment() {

    private lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_management, container, false)
    }
}
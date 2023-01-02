package com.example.cinemaapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.example.cinemaapp.adapters.ViewPagerAdapter
import com.example.cinemaapp.databinding.ActivityMainBinding
import com.example.cinemaapp.fragments.DBFragment
import com.example.cinemaapp.fragments.MapFragment
import com.example.cinemaapp.fragments.NotificationsFragment
import com.example.cinemaapp.fragments.UserManagementFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpTabs()

        val fab: FloatingActionButton = binding.fab

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    private fun setUpTabs() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(MapFragment(), "Map")
        adapter.addFragment(DBFragment(), "DB")
        adapter.addFragment(NotificationsFragment(), "Notifications")
        adapter.addFragment(UserManagementFragment(), "User Management")
        binding.viewPager.adapter = adapter
        binding.tabs.setupWithViewPager(binding.viewPager)
    }
}

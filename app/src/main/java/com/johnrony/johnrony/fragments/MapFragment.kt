package com.example.cinemaapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.cinemaapp.R
import com.example.cinemaapp.viewmodels.MovieViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapFragment : Fragment(), OnMapReadyCallback {

    private lateinit var mapView: MapView
    private lateinit var googleMap: GoogleMap
    private val movieViewModel: MovieViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_map, container, false)
        mapView = view.findViewById(R.id.map_view)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)
        return view
    }

    override fun onMapReady(map: GoogleMap?) {
        map?.let {
            googleMap = it
            movieViewModel.movies.observe(viewLifecycleOwner, { movies ->
                for (movie in movies) {
                    val location = LatLng(movie.latitude, movie.longitude)
                    googleMap.addMarker(MarkerOptions().position(location).title(movie.title))
                }
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(51.509865, -0.118092), 10f))
            })
            googleMap.setOnInfoWindowClickListener {
                val directions =
                    MapFragmentDirections.actionMapFragmentToMovieFragment(it.title)
                findNavController().navigate(directions)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }
}

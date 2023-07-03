package com.example.eighteenadult.map

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.eighteenadult.R
import com.example.eighteenadult.home.HomeFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapFragment : Fragment(), OnMapReadyCallback {

    private var viewGroup: ViewGroup? = null

    private lateinit var googleMap : GoogleMap
    private lateinit var mapView : MapView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewGroup = inflater.inflate(R.layout.fragment_map, container, false) as ViewGroup?

        // 지도
        mapView = viewGroup?.findViewById(R.id.mv_map)!!
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)

        return viewGroup
    }

    override fun onMapReady(gm: GoogleMap) {
        // LatLng = 위도/경도를 나타낼 수 있는 좌표 클래스
        var phnomPenh = LatLng(11.5795208, 104.8077867)

        googleMap = gm

        val markerOptions = MarkerOptions()
        // 마커 위치 할당 (필수)
        markerOptions.position(phnomPenh)
        googleMap.addMarker(markerOptions)
        // 마커가 있는 곳까지 화면을 움직임
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(phnomPenh, 15F))
    }
}
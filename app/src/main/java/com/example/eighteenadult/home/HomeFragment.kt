package com.example.eighteenadult.home

import android.content.Context.LOCATION_SERVICE
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eighteenadult.R
import com.google.android.gms.location.LocationListener
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class HomeFragment : Fragment(), OnMapReadyCallback {

    private var viewGroup: ViewGroup? = null

    private lateinit var googleMap: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewGroup = inflater.inflate(R.layout.fragment_home, container, false) as ViewGroup?

        // 지도
        val mapView: MapView? = viewGroup?.findViewById(R.id.mapView)
        mapView?.onCreate(savedInstanceState)
        mapView?.getMapAsync(this)

        // 카드
        val recyclerView: RecyclerView? = viewGroup?.findViewById(R.id.recyclerView)

        val job = Card("최근", "일자리 지원", R.drawable.home_icon_card_1)
        val salary = Card("자주", "급여 지원", R.drawable.home_icon_card_2)
        val seeMore = Card("전체", "더보기", R.drawable.home_icon_card_1)

        var card = ArrayList<Card>()
        card.add(job)
        card.add(salary)
        card.add(seeMore)

        recyclerView?.adapter = CardAdapter(activity, card)

        var linearLayoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        recyclerView?.layoutManager = linearLayoutManager

        return viewGroup
    }

    override fun onMapReady(gm: GoogleMap) {
        // LatLng = 위도/경도를 나타낼 수 있는 좌표 클래스
        var phnomPenh = LatLng(11.5795208, 104.8077867)

        googleMap = gm

        mLocationManager = activity?.getSystemService(LOCATION_SERVICE) as LocationManager
        mLocationListener = object : LocationListener {
            override fun onLocationChanged(p0: Location) {
                var lat = 0.0
                var lng = 0.0
                if (p0 != null) {
                    lat = p0.latitude
                    lng = p0.longitude
                    Log.d("GmapViewFragment", "Lat: ${lat}, lon: ${lng}")
                }
                var currentLocation = LatLng(lat, lng)
                googleMap!!.addMarker(MarkerOptions().position(currentLocation).title("현재위치"))
                googleMap!!.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 3f))
            }
        }
    }

    // 위치 서비스에 접근하는 클래스를 제공
    var mLocationManager: LocationManager? = null

    // 위치가 변할 때 알림을 받는 용도
    var mLocationListener: LocationListener? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mLocationManager = activity?.getSystemService(LOCATION_SERVICE) as LocationManager
        mLocationListener = object : LocationListener {
            override fun onLocationChanged(p0: Location) {
                var lat = 0.0
                var lng = 0.0
                if (p0 != null) {
                    lat = p0.latitude
                    lng = p0.longitude
                    Log.d("GmapViewFragment", "Lat: ${lat}, lon: ${lng}")
                }
                var currentLocation = LatLng(lat, lng)
                googleMap!!.addMarker(MarkerOptions().position(currentLocation).title("현재위치"))
                googleMap!!.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 15f))
            }
        }
    }
}
package com.example.eighteenadult.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eighteenadult.MainActivity
import com.example.eighteenadult.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class HomeFragment : Fragment(), OnMapReadyCallback {

    private var viewGroup: ViewGroup? = null

    private lateinit var googleMap : GoogleMap
    private lateinit var mapView : MapView

    lateinit var fl_map : FrameLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewGroup = inflater.inflate(R.layout.fragment_home, container, false) as ViewGroup?

        // 지도
        fl_map = viewGroup?.findViewById(R.id.fl_map)!!
        fl_map.setOnClickListener {
            val mainActivity = (activity as MainActivity)
            mainActivity.changeFragment(1)
        }

        mapView = viewGroup?.findViewById(R.id.mv_home)!!
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)

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

        val markerOptions = MarkerOptions()
        // 마커 위치 할당 (필수)
        markerOptions.position(phnomPenh)
        googleMap.addMarker(markerOptions)
        // 마커가 있는 곳까지 화면을 움직임
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(phnomPenh, 15F))
    }
}
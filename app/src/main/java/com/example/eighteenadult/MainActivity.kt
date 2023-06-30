package com.example.eighteenadult

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.eighteenadult.home.HomeFragment
import com.example.eighteenadult.information.InformationFragment
import com.example.eighteenadult.map.MapFragment
import com.example.eighteenadult.user.UserFragment
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val homeFragment : Fragment = HomeFragment()
        val mapFragment : Fragment = MapFragment()
        val informationFragment : Fragment = InformationFragment()
        val userFragment : Fragment = UserFragment()

        // 최초로 나타날 Fragment 세팅
        fragmentTransaction.add(R.id.frameLayout, homeFragment).commit()

        val tabLayout : TabLayout = findViewById<View>(R.id.tabLayout) as TabLayout

        // TabLayout 선택 이벤트 리스너
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            // Tab을 선택했을 때
            override fun onTabSelected(tab: TabLayout.Tab?) {
                // 이미 위에서 Fragment가 할당되고 commit을 하였기 때문에 새로운 transaction를 생성
                val newFragmentTransaction = supportFragmentManager.beginTransaction()
                // 선택된 Tab의 position 값을 받아와서 해당 Tab에 맞는 Fragment를 띄워줌
                when(tab?.position) {
                    // HomeFragment 선택 시
                    // replace: 원래 있던 Fragment를 지우고 새 Fragment로 교체
                    0 -> {
                        newFragmentTransaction.replace(R.id.frameLayout, homeFragment)
                        newFragmentTransaction.commit()
                    }
                    // MapFragment 선택 시
                    1 -> {
                        newFragmentTransaction.replace(R.id.frameLayout, mapFragment)
                        newFragmentTransaction.commit()
                    }
                    // InformationFragment 선택 시
                    2 -> {
                        newFragmentTransaction.replace(R.id.frameLayout, informationFragment)
                        newFragmentTransaction.commit()
                    }
                    // UserFragment 선택 시
                    3 -> {
                        newFragmentTransaction.replace(R.id.frameLayout, userFragment)
                        newFragmentTransaction.commit()
                    }
                }
            }

            // 선택되어 있는 탭에서 선택되지 않음으로 바뀌었을 때
            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            // 이미 선택되어 있는 탭이 다시 선택 되었을 때
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }
}
package com.example.eighteenadult.information

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.eighteenadult.R
import com.google.android.material.tabs.TabLayout

class InformationFragment : Fragment() {

    private var viewGroup: ViewGroup? = null

    lateinit var tabLayout : TabLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewGroup = inflater.inflate(R.layout.fragment_information, container, false) as ViewGroup?

        tabLayout = viewGroup?.findViewById(R.id.tabLayout)!!

        val fragmentTransaction = fragmentManager?.beginTransaction()
        val youthJobsFragment : Fragment = YouthJobsFragment()
        val informationSupportFragment : Fragment = InformationSupportFragment()
        val shelterFragment : Fragment = ShelterFragment()

        // 최초로 나타날 Fragment 세팅
        fragmentTransaction?.add(R.id.fl_information, youthJobsFragment)?.commit()

        // TabLayout 선택 이벤트 리스너
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            // Tab을 선택했을 때
            override fun onTabSelected(tab: TabLayout.Tab?) {
                // 이미 위에서 Fragment가 할당되고 commit을 하였기 때문에 새로운 transaction를 생성
                val newFragmentTransaction = fragmentManager?.beginTransaction()
                // 선택된 Tab의 position 값을 받아와서 해당 Tab에 맞는 Fragment를 띄워줌
                when(tab?.position) {
                    // replace: 원래 있던 Fragment를 지우고 새 Fragment로 교체
                    // 보호시설 선택 시
                    0 -> {
                        newFragmentTransaction?.replace(R.id.fl_information, youthJobsFragment)
                        newFragmentTransaction?.commit()
                    }
                    // 청년일자리 선택 시
                    1 -> {
                        newFragmentTransaction?.replace(R.id.fl_information, informationSupportFragment)
                        newFragmentTransaction?.commit()
                    }
                    // 정보 지원 선택 시
                    2 -> {
                        newFragmentTransaction?.replace(R.id.fl_information, shelterFragment)
                        newFragmentTransaction?.commit()
                    }
                }
            }

            // 선택되어 있는 탭에서 선택되지 않음으로 바뀌었을 때
            override fun onTabUnselected(tab: TabLayout.Tab?) {
                android.util.Log.v("unSelect", "${tab?.position}이 선택되지 않음")
            }

            // 이미 선택되어 있는 탭이 다시 선택 되었을 때
            override fun onTabReselected(tab: TabLayout.Tab?) {
                android.util.Log.v("reSelect", "${tab?.position}을 다시 선택함")
            }
        })

        return viewGroup
    }
}
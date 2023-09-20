package com.stac.eighteenadult.information

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.stac.eighteenadult.home.HomeActivity
import com.stac.eighteenadult.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.Tab

class InformationActivity : AppCompatActivity() {

    lateinit var iv_back : ImageView

    lateinit var iv_detail_image : ImageView
    lateinit var tv_detail_title : TextView
    lateinit var tv_detail_subtitle : TextView

    lateinit var tabLayout : TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)

        // 뒤로 가기
        iv_back = findViewById(R.id.iv_back)
        iv_back.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            this.startActivity(intent)
        }

        // 상단 디테일 클릭 시 화면 전환
        iv_detail_image = findViewById(R.id.iv_detail_image)
        tv_detail_title = findViewById(R.id.tv_detail_title)
        tv_detail_subtitle = findViewById(R.id.tv_detail_subtitle)

        iv_detail_image.setOnClickListener {
            changeInformationDetail()
        }

        tv_detail_title.setOnClickListener {
            changeInformationDetail()
        }

        tv_detail_subtitle.setOnClickListener {
            changeInformationDetail()
        }

        // 하단 탭 레이아웃 구현
        tabLayout = findViewById(R.id.tabLayout)
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val youthJobsFragment : Fragment = YouthJobsFragment()
        val informationSupportFragment : Fragment = InformationSupportFragment()
        val shelterFragment : Fragment = ShelterFragment()

        // 초반 Fragment 세팅 (add: Fragment 추가)
        // 마지막에 commit()을 해줘야 결과가 반영
        fragmentTransaction.add(R.id.fl_information, youthJobsFragment).commit()

        // TabLayout 선택 이벤트 리스너
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            // Tab을 선택했을 때
            override fun onTabSelected(tab: Tab?) {
                // 이미 위에서 Fragment가 할당되고 commit을 하였기 때문에 새로운 transaction를 생성
                val newFragmentTransaction = supportFragmentManager.beginTransaction()
                // 선택된 Tab의 position 값을 받아와서 해당 Tab에 맞는 Fragment를 띄워줌
                when(tab?.position) {
                    // replace: 원래 있던 Fragment를 지우고 새 Fragment로 교체
                    // 보호시설 선택 시
                    0 -> {
                        newFragmentTransaction.replace(R.id.fl_information, youthJobsFragment)
                        newFragmentTransaction.commit()
                    }
                    // 청년일자리 선택 시
                    1 -> {
                        newFragmentTransaction.replace(R.id.fl_information, informationSupportFragment)
                        newFragmentTransaction.commit()
                    }
                    // 정보 지원 선택 시
                    2 -> {
                        newFragmentTransaction.replace(R.id.fl_information, shelterFragment)
                        newFragmentTransaction.commit()
                    }
                }
            }

            // 선택되어 있는 탭에서 선택되지 않음으로 바뀌었을 때
            override fun onTabUnselected(tab: Tab?) {
                Log.v("unSelect", "${tab?.position}이 선택되지 않음")
            }

            // 이미 선택되어 있는 탭이 다시 선택 되었을 때
            override fun onTabReselected(tab: Tab?) {
                Log.v("reSelect", "${tab?.position}을 다시 선택함")
            }
        })
    }

    private fun changeInformationDetail() {
        val intent = Intent(this, InformationDetailActivity::class.java)
        this.startActivity(intent)
    }
}
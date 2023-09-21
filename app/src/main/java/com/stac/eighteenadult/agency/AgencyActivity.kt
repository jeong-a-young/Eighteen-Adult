package com.stac.eighteenadult.agency

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eighteenadult.R
import com.stac.eighteenadult.home.HomeActivity

class AgencyActivity : AppCompatActivity() {

    lateinit var iv_back : ImageView
    lateinit var iv_bookmark : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agency)

        // 뒤로 가기
        iv_back = findViewById(R.id.iv_back)
        iv_back.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            this.startActivity(intent)
        }

        // 기관
        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)

        var agency_1 = Agency("성남시중장기청소년쉼터", "경기도 성남시 중원구 박석로", "경기도 성남시 중원구 상대원동 박석로41번길 25", R.drawable.agency_image_1, "031-758-1720", false)
        var agency_2 = Agency("성남시일시청소년쉼터", "경기도 성남시 중원구 성남동", "경기 성남시 중원구 광명로 5 10층", 0, "031-758-1388", true)
        var agency_3 = Agency("성남시여자단기청소년쉼터", "경기도 성남시 중원구 하대원동", "경기 성남시 중원구 마지로 29", 0, "031-758-1213", false)
        var agency_4 = Agency("용인푸른꿈남자청소년쉼터", "경기도 용인시 수지구 풍덕천동", "경기 용인시 수지구 문인로39번길 7", R.drawable.agency_image_2, "031-276-0770", false)
        var agency_5 = Agency("용인푸른꿈여자청소년쉼터", "경기도 용인시 수지구 풍덕천1동", "경기 용인시 수지구 풍덕천로189번길 4-11 3층", 0, "0507-1491-7734", false)
        var agency_6 = Agency("수원여자단기청소년쉼터", "경기도 수원시 팔달구 팔달로3가", "경기 수원시 팔달구 행궁로 77 3층", R.drawable.agency_image_3, "031-232-7982", false)

        var agency = ArrayList<Agency>()
        agency.add(agency_1)
        agency.add(agency_2)
        agency.add(agency_3)
        agency.add(agency_4)
        agency.add(agency_5)
        agency.add(agency_6)

        recyclerView.adapter = AgencyAdapter(this, agency)

        var linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager

        // 북마크
        iv_bookmark = findViewById(R.id.iv_bookmark)
        iv_bookmark.setOnClickListener {
            val intent = Intent(this, AgencyBookmarkActivity::class.java)
            this.startActivity(intent)
        }
    }
}
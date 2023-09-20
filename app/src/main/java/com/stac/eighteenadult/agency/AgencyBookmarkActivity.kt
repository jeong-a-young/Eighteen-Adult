package com.stac.eighteenadult.agency

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.stac.eighteenadult.R

class AgencyBookmarkActivity : AppCompatActivity() {

    lateinit var iv_back : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agency_bookmark)

        // 뒤로 가기
        iv_back = findViewById(R.id.iv_back)
        iv_back.setOnClickListener {
            val intent = Intent(this, AgencyActivity::class.java)
            this.startActivity(intent)
        }

        // 북마크
        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)

        var bookmark_1 = Agency("성남시일시청소년쉼터", "경기도 성남시 중원구 성남동", "경기 성남시 중원구 광명로 5 10층", 0, "031-758-1388", true)

        var bookmark = ArrayList<Agency>()
        bookmark.add(bookmark_1)

        recyclerView.adapter = AgencyAdapter(this, bookmark)

        var linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager
    }
}
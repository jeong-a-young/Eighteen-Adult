package com.stac.eighteenadult.entire

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.stac.eighteenadult.home.HomeActivity
import com.stac.eighteenadult.R

class EntireActivity : AppCompatActivity() {

    lateinit var iv_back : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entire)

        // 뒤로 가기
        iv_back = findViewById(R.id.iv_back)
        iv_back.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            this.startActivity(intent)
        }

        // 최근
        val rv_recent : RecyclerView = findViewById(R.id.rv_recent)

        var recent_1 = Entire(R.drawable.entire_icon_bag, "일자리 정보")
        var recent_2 = Entire(R.drawable.entire_icon_bag, "청년 일자리 정보")
        var recent_3 = Entire(R.drawable.entire_icon_folders, "2023년 LH 전세임대 입주자")

        var recent = ArrayList<Entire>()
        recent.add(recent_1)
        recent.add(recent_2)
        recent.add(recent_3)

        rv_recent.adapter = RecentAdapter(this, recent)

        var recentLinearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rv_recent.layoutManager = recentLinearLayoutManager

        // 전체
        val rv_entire : RecyclerView = findViewById(R.id.rv_entire)

        var entire_1 = Entire(R.drawable.entire_icon_bag, "일자리 지원")
        var entire_2 = Entire(R.drawable.entire_icon_folder, "보호시설 정보")
        var entire_3 = Entire(R.drawable.entire_icon_bag, "청년 일자리 정보")
        var entire_4 = Entire(R.drawable.entire_icon_file, "보호 종료 확인서")
        var entire_5 = Entire(R.drawable.entire_icon_card, "급여 지원")
        var entire_6 = Entire(R.drawable.entire_icon_user, "지역사회 기반 자살 예방사업")
        var entire_7 = Entire(R.drawable.entire_icon_rainbow, "사회적 기업")
        var entire_8 = Entire(R.drawable.entire_icon_folders, "2023년 LH 전세임대 입주자")

        var entire = ArrayList<Entire>()
        entire.add(entire_1)
        entire.add(entire_2)
        entire.add(entire_3)
        entire.add(entire_4)
        entire.add(entire_5)
        entire.add(entire_6)
        entire.add(entire_7)
        entire.add(entire_8)

        rv_entire.adapter = EntireAdapter(this, entire)

        var entireLinearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rv_entire.layoutManager = entireLinearLayoutManager
    }
}
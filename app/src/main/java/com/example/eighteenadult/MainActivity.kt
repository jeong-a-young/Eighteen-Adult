package com.example.eighteenadult

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eighteenadult.agency.AgencyActivity
import com.example.eighteenadult.entire.EntireActivity
import com.example.eighteenadult.home.Card
import com.example.eighteenadult.home.CardAdapter
import com.example.eighteenadult.information.InformationActivity

class MainActivity : AppCompatActivity() {

    lateinit var iv_information : ImageView
    lateinit var iv_agency : ImageView
    lateinit var ll_entire : LinearLayout
    lateinit var tv_entire_subtitle : TextView
    lateinit var tv_entire_title : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 정보
        iv_information = findViewById(R.id.iv_information)
        iv_information.setOnClickListener {
            val intent = Intent(this, InformationActivity::class.java)
            this.startActivity(intent)
        }

        // 기관
        iv_agency = findViewById(R.id.iv_agency)
        iv_agency.setOnClickListener {
            val intent = Intent(this, AgencyActivity::class.java)
            this.startActivity(intent)
        }

        // 카드
        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)

        val job = Card("최근", "일자리 지원", R.drawable.home_icon_card_1)
        val salary = Card("자주", "급여 지원", R.drawable.home_icon_card_2)

        var card = ArrayList<Card>()
        card.add(job)
        card.add(salary)

        recyclerView.adapter = CardAdapter(this, card)

        var linearLayoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        recyclerView.layoutManager = linearLayoutManager

        // 전체
        ll_entire = findViewById(R.id.ll_entire)
        tv_entire_subtitle = findViewById(R.id.tv_entire_subtitle)
        tv_entire_title = findViewById(R.id.tv_entire_title)

        ll_entire.setOnClickListener {
            changeEntire()
        }

        tv_entire_subtitle.setOnClickListener {
            changeEntire()
        }

        tv_entire_title.setOnClickListener {
            changeEntire()
        }
    }

    private fun changeEntire() {
        val intent = Intent(this, EntireActivity::class.java)
        this.startActivity(intent)
    }
}
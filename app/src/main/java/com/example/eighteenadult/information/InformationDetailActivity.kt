package com.example.eighteenadult.information

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.eighteenadult.R

class InformationDetailActivity : AppCompatActivity() {

    lateinit var iv_back : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information_detail)

        iv_back = findViewById(R.id.iv_back)
        iv_back.setOnClickListener {
            val intent = Intent(this, InformationActivity::class.java)
            this.startActivity(intent)
        }
    }
}
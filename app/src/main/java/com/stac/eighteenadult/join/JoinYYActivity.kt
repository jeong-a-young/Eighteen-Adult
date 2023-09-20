package com.stac.eighteenadult.join

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.stac.eighteenadult.R

class JoinYYActivity : AppCompatActivity() {

    lateinit var iv_back : ImageView
    lateinit var btn_submit : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join_yy)

        // 뒤로 가기
        iv_back = findViewById(R.id.iv_back)
        iv_back.setOnClickListener {
            val intent = Intent(this, JoinYActivity::class.java)
            this.startActivity(intent)
        }

        btn_submit = findViewById(R.id.btn_submit)
    }
}
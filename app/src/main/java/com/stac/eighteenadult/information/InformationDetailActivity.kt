package com.stac.eighteenadult.information

import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import com.example.eighteenadult.R

class InformationDetailActivity : AppCompatActivity() {

    lateinit var iv_back : ImageView
    lateinit var btn_share : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information_detail)

        iv_back = findViewById(R.id.iv_back)
        iv_back.setOnClickListener {
            val intent = Intent(this, InformationActivity::class.java)
            this.startActivity(intent)
        }

        btn_share = findViewById(R.id.btn_share)
        btn_share.setOnClickListener {
            try {
                val content = "스무 살 함께 서기"
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, content)
                intent.type = "text/plain"
                startActivity(Intent.createChooser(intent, "Share"))
            } catch (ignored: ActivityNotFoundException) {
                Log.d("test", "ignored : $ignored")
            }
        }
    }
}
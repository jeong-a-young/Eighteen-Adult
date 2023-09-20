package com.stac.eighteenadult.join

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.stac.eighteenadult.R
import com.stac.eighteenadult.home.HomeActivity

class JoinFinalActivity : AppCompatActivity() {

    lateinit var btn_finish : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join_final)

        btn_finish = findViewById(R.id.btn_finish)
        btn_finish.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            this.startActivity(intent)
        }
    }
}
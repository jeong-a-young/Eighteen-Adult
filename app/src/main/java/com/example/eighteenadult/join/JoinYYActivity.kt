package com.example.eighteenadult.join

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.eighteenadult.R

class JoinYYActivity : AppCompatActivity() {

    lateinit var btn_submit : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join_yy)

        btn_submit = findViewById(R.id.btn_submit)
        btn_submit.setOnClickListener {
            val intent = Intent(this, JoinYNActivity::class.java)
            this.startActivity(intent)
        }
    }
}
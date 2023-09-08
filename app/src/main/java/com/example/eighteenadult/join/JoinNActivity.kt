package com.example.eighteenadult.join

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.eighteenadult.R

class JoinNActivity : AppCompatActivity() {

    lateinit var btn_finish : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join_n)

        btn_finish = findViewById(R.id.btn_finish)
        btn_finish.setOnClickListener {
        }
    }
}
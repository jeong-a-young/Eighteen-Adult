package com.example.eighteenadult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.eighteenadult.login.LoginActivity

class BeginningActivity : AppCompatActivity() {

    lateinit var btn_start : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beginning)

        btn_start = findViewById(R.id.btn_start)
        btn_start.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
package com.example.eighteenadult.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.eighteenadult.R
import com.example.eighteenadult.join.JoinActivity

class LoginActivity : AppCompatActivity() {

    lateinit var btn_finish : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_finish = findViewById(R.id.btn_no)
        btn_finish.setOnClickListener {
            val intent = Intent(this, JoinActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
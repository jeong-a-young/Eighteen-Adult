package com.stac.eighteenadult.join

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.stac.eighteenadult.R

class JoinYNActivity : AppCompatActivity() {

    lateinit var btn_yes : Button
    lateinit var btn_no : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join_yn)

        btn_yes = findViewById(R.id.btn_yes)
        btn_yes.setOnClickListener {
            val intent = Intent(this, JoinFinalActivity::class.java)
            this.startActivity(intent)
        }

        btn_no = findViewById(R.id.btn_no)
        btn_no.setOnClickListener {
            val intent = Intent(this, JoinFinalActivity::class.java)
            this.startActivity(intent)
        }
    }
}
package com.example.iubupdates

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.home_screen.*

class Home_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_screen)

        point_btn.setOnClickListener {

            startActivity(Intent(this,Point_Schedule::class.java))
        }
    }
}
package com.example.iubupdates

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.point_schedule.*

class Point_Schedule : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.point_schedule)

        B_to_A.setOnClickListener {
            startActivity(Intent(this,PointActivity::class.java))


        }
    }
}
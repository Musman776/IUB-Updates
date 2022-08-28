package com.example.iubupdates

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

@Suppress("DEPRECATION")
class Splash_Screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

            supportActionBar?.hide()
        Handler().postDelayed({

            startActivity(Intent(this@Splash_Screen,Home_screen::class.java))
            finish()

        },1000)

    }
}
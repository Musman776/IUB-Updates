package com.example.iubupdates

import android.animation.ValueAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.LinearInterpolator
import kotlinx.android.synthetic.main.splash_screen.*

@Suppress("DEPRECATION")
class Splash_Screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
            supportActionBar?.hide()

   splash_img.translationX = -15000f
        splash_img.animate().translationX(0f).duration=2000



        Handler().postDelayed({

            startActivity(Intent(this@Splash_Screen,Home_screen::class.java))
            finish()

        },3000)

    }
}
package com.maxataliyev_01.quizlet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.ActionBar

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        handler= Handler()
        handler.postDelayed({
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        },1500)

    }
}
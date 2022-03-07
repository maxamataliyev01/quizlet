package com.maxataliyev_01.quizlet

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        val username=intent.getStringExtra(setData.name)
        val score=intent.getStringExtra(setData.score)
        val totalQuestion=intent.getStringExtra(setData.score)
        congo.text="Congratulations$username!!"
        Scores.text="${score}/${totalQuestion}"
        button.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }
    }
}
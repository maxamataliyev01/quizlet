package com.maxataliyev_01.quizlet.gameType

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import com.maxataliyev_01.quizlet.R

class QuestionPage : AppCompatActivity() {
    private lateinit var btnChooseType:AppCompatButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_page)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()
        btnChooseType=findViewById(R.id.choose)
        btnChooseType.setOnClickListener { startActivity(Intent(this,FindAnswerActivity::class.java)) }
        btnChooseType=findViewById(R.id.image)
        btnChooseType.setOnClickListener { startActivity(Intent(this,FindImageActivity::class.java)) }
        btnChooseType=findViewById(R.id.write)
        btnChooseType.setOnClickListener { startActivity(Intent(this,WriteAnswerActivity::class.java)) }
        btnChooseType=findViewById(R.id.timer)
        btnChooseType.setOnClickListener { startActivity(Intent(this,TimerAnswerActivity::class.java)) }

    }
}
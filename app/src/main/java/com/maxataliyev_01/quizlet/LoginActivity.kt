package com.maxataliyev_01.quizlet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.maxataliyev_01.quizlet.gameType.QuestionPage
import kotlinx.android.synthetic.main.activity_question_page.*

class LoginActivity : AppCompatActivity() {
    private lateinit var buttonPlay:AppCompatButton
    private lateinit var name:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        buttonPlay=findViewById(R.id.playbtn)
        name=findViewById(R.id.nameEnter)
        buttonPlay.setOnClickListener {
            if(name.text.toString().isNotEmpty()){
                startActivity(Intent(this, QuestionPage::class.java))
                intent.putExtra("${setData.name}",playerName.text.toString())
                finish()
            }else Toast.makeText(this, "Forgot enter your name", Toast.LENGTH_SHORT).show()
        }
    }
}
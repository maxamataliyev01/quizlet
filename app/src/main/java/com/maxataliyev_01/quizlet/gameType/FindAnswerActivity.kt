package com.maxataliyev_01.quizlet.gameType

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.maxataliyev_01.quizlet.R
import com.maxataliyev_01.quizlet.ResultActivity
import com.maxataliyev_01.quizlet.model.QuestionData
import com.maxataliyev_01.quizlet.setData
import kotlinx.android.synthetic.main.findanswer_activity.*

class FindAnswerActivity : AppCompatActivity() {
    private var Name:String?=null
    private var score:Int=0
    private var currentPosition:Int=1
    private var questionList:ArrayList<QuestionData>?=null
    private var selectedOption=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.findanswer_activity)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN

        Name=intent.getStringExtra(setData.name)


        questionList=setData.getQuestion()
        setQuestion()


        opt_1.setOnClickListener{
            selectedOptionStyle(opt_1,1)
        }
        opt_2.setOnClickListener{
            selectedOptionStyle(opt_2,2)
        }
        opt_3.setOnClickListener{
            selectedOptionStyle(opt_3,3)
        }
        opt_4.setOnClickListener{
            selectedOptionStyle(opt_4,4)
        }
        submit_btn.setOnClickListener {
            if(selectedOption!=0) {
                val question = questionList!![currentPosition - 1]
                if (selectedOption != question.correct_ans) {
                    setColor(selectedOption, R.drawable.wrong_question_option)
                }else score++
                setColor(question.correct_ans, R.drawable.correct_question_option)
                if (currentPosition == questionList!!.size)
                    submit_btn.text = "FINISH"
                else
                    submit_btn.text="Go to Next"
            }
             else{
                 currentPosition++
                when{
                    currentPosition <= questionList!!.size->{
                        setQuestion()
                    }else->{
                    var intent=Intent(this,ResultActivity::class.java)
                    intent.putExtra(setData.name,Name.toString())
                    intent.putExtra(setData.score,score.toString())
                    intent.putExtra("total size",questionList!!.size.toString())
                    startActivity(intent)
                    finish()
                    }
                }
            }
            selectedOption=0
        }
    }
    fun setColor(opt: Int,color: Int){
        when(opt){
            1->{
                opt_1.background=ContextCompat.getDrawable(this,color)
            }
            1->{
                opt_1.background=ContextCompat.getDrawable(this,color)
            }
            2->{
                opt_2.background=ContextCompat.getDrawable(this,color)
            }
            3->{
                opt_3.background=ContextCompat.getDrawable(this,color)
            }
            4->{
                opt_4.background=ContextCompat.getDrawable(this,color)
            }



        }


    }

    fun setQuestion(){
        val question=questionList!![currentPosition-1]
        setOptionStyle()
        progress_bar.progress=currentPosition
        progress_bar.max=questionList!!.size
        progress_text.text="${currentPosition}"+"/"+"${questionList!!.size}"
        question_text.text=question.question
        opt_1.text=question.option_one
        opt_2.text=question.option_two
        opt_3.text=question.option_three
        opt_4.text=question.option_four
    }


    fun setOptionStyle(){
        var optionList:ArrayList<TextView> = arrayListOf()
        optionList.add(0,opt_1)
        optionList.add(1,opt_2)
        optionList.add(2,opt_3)
        optionList.add(3,opt_4)

        for (i in optionList){
            i.setTextColor(Color.parseColor("#555151"))
            i.background=ContextCompat.getDrawable(this,R.drawable.question_option)
            i.typeface= Typeface.DEFAULT
        }
    }


    fun selectedOptionStyle(view:TextView,opt:Int){
        setOptionStyle()
        selectedOption=opt
        view.background=ContextCompat.getDrawable(this,R.drawable.selected_question_option)
        view.typeface= Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))
    }
}
package com.maxataliyev_01.quizlet

import com.maxataliyev_01.quizlet.model.QuestionData

object setData {
    const val name:String="name"
    const val score:String="score"
    fun getQuestion():ArrayList<QuestionData>{
        var que:ArrayList<QuestionData> = arrayListOf()
        var q1=QuestionData("What is the capital of Uzbekistan?",
            1,
            "Samarkand",
            "Tashkent",
            "Namangan",
            "Jazzakh",
            2
        )
        var q2=QuestionData("How many sides are there in a triangle?",
            2,
            "3",
            "4",
            "2",
            "7",
            1
        )
        var q3=QuestionData("Which month of the year has the least number of days?",
            3,
            "December",
            "January",
            "February",
            "March",
            3
        )
        var q4=QuestionData("Which is the tallest animal on the earth?",
            4,
            "Lion",
            "Eiffel",
            "Giraffe",
            "Camel",
            3
        )
        var q5=QuestionData("What is the top color in a rainbow?",
            5,
            "Blue",
            "Yellow",
            "Green",
            "Red",
            4
        )
        que.add(q1)
        que.add(q2)
        que.add(q3)
        que.add(q4)
        que.add(q5)
        return que
    }
}
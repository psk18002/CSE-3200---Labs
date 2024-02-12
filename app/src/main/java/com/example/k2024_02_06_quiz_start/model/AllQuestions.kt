package com.example.k2024_02_06_quiz_start.model

import com.example.k2024_02_06_quiz_start.model.Question

class AllQuestions {

    val allQuestions = arrayListOf<Question<Boolean>>(
        Question("There are 365 days in a year.", true, Difficulty.EASY),
        Question("There are seven seas.", true, Difficulty.EASY),
        Question("The composer of Antar No.7 is Lizst.", false, Difficulty.HARD)
    )

    fun getNumberOfQuestions() : Int {
        return allQuestions.size
    }

    fun getQuestion(i: Int): Question<Boolean> {
        return allQuestions[i]
    }
}
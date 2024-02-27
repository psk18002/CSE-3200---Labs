package com.example.k2024_02_06_quiz_start.model

import com.example.k2024_02_06_quiz_start.model.Question

class AllQuestions {

    val allQuestions = arrayListOf<Question<Any>>(
        Question("There are 365 days in a year.", true, Difficulty.EASY, false),
        Question("There are seven seas.", true, Difficulty.EASY, false),
        Question("The composer of Antar No.7 is Lizst.", false, Difficulty.HARD, false),
        Question("The United States of America is located on North America.", true, Difficulty.EASY, false),
        Question("1+1 equals", "2", Difficulty.EASY, true),
        Question("Robert Hook first discovered and stipulated the laws of motion.", false, Difficulty.MEDIUM, true)
    )

    fun getNumberOfQuestions() : Int {
        return allQuestions.size
    }

    fun getQuestion(i: Int): Question<Any> {
        return allQuestions[i]
    }
}
package com.example.k2024_02_06_quiz_start.controller

import com.example.k2024_02_06_quiz_start.model.AllQuestions

class NextQuestion {

    private val totalQuestions = AllQuestions().getNumberOfQuestions()
    companion object {private var currentQuestion = 0}

    fun getNextIncQuestionNumber() : Int {
        currentQuestion = (currentQuestion + 1) % totalQuestions
        return currentQuestion
    }

    fun getNextRandomQuestionNumber() : Int {
        val getRand = (0 .. totalQuestions-1).random()
        return getRand
    }
}
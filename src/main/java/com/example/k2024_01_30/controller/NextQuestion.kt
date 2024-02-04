package com.example.k2024_01_30.controller
import com.example.k2024_01_30.model.AllQuestions

class NextQuestion {
    private val questions = AllQuestions()
    val totalQuestions = questions.totalQuestions()
}
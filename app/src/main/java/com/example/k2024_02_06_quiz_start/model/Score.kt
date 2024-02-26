package com.example.k2024_02_06_quiz_start.model

class Score{

    fun incrementTotalQuestions() {
        totalQuestions++
    }
    fun updateScore(newScore: Double) {
        score = newScore
    }
    fun incrementScore(scoreChange : Double) {
        incrementTotalQuestions()
        score += scoreChange
    }

    companion object {
        private var score = 0.0
        private var totalQuestions = 0
    }

    fun getScore(): Double {
        return score
    }

}
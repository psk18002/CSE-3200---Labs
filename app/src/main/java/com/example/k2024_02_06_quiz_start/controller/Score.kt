package com.example.k2024_02_06_quiz_start.controller

import com.example.k2024_02_06_quiz_start.model.UserIdentification

class Score (){

    companion object {
        private var score = 0
    }
    fun incrementScore() {
        score++
    }

    fun getScore(): Int {
        return score
    }
}
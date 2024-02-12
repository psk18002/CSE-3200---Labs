package com.example.k2024_02_06_quiz_start.model

import com.example.k2024_02_06_quiz_start.controller.Score

class UserIdentification() {
    private var name : String? = null
    val userScore = Score()

    fun getName() : String? {
        return name
    }

    fun setName(uName : String?)  {
        name = uName
    }

}
package com.example.k2024_02_06_quiz_start.model

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
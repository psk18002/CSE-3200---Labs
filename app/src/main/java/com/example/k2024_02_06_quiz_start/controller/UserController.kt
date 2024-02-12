package com.example.k2024_02_06_quiz_start.controller

import com.example.k2024_02_06_quiz_start.model.UserIdentification

class UserController(private val userIdentification: UserIdentification) {
    fun setName(name : String?) {
        userIdentification.setName(name)
    }

    fun getName() : String? {
        return userIdentification.getName()
    }
}
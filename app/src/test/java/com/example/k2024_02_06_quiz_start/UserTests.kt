package com.example.k2024_02_06_quiz_start

import com.example.k2024_02_06_quiz_start.controller.UserController
import com.example.k2024_02_06_quiz_start.model.UserIdentification
import org.junit.Test
import org.junit.Assert

class UserControllerTest {
    @Test
    fun userID_init() {
        val userID = UserIdentification()

        Assert.assertEquals(userID.getName(), null)
        Assert.assertEquals((userID.userScore.getScore()), 0)
    }

    @Test
    fun userID_setName() {
        val userID = UserIdentification()
        val userCon = UserController(userID)

        userCon.setName("Adam")
        Assert.assertEquals(userCon.getName(), "Adam")
    }

    @Test
    fun userID_getName() {
        val userID = UserIdentification()
        val userCon = UserController(userID)

        Assert.assertEquals(userCon.getName(), null)
    }
}
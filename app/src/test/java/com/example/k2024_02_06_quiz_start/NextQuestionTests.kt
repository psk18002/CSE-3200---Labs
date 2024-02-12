package com.example.k2024_02_06_quiz_start

import com.example.k2024_02_06_quiz_start.model.AllQuestions
import com.example.k2024_02_06_quiz_start.controller.NextQuestion
import org.junit.Test

import org.junit.Assert

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class NextQuestionTest {
    @Test
    fun getNextIncQuestionNumberTest_1() {
        val allQuestions = AllQuestions()
        val currentQuestion = 0

        val nextQuestion = NextQuestion()

        Assert.assertEquals(nextQuestion.getNextIncQuestionNumber(), currentQuestion + 1)
    }

    @Test
    fun getNextRandomQuestionNumberTest_1() {
        val allQuestions = AllQuestions()
        val totalNumberOfQuestions = AllQuestions().getNumberOfQuestions()
        val nextQuestion = NextQuestion()

        Assert.assertTrue(nextQuestion.getNextRandomQuestionNumber() in (0 ..totalNumberOfQuestions))
    }

    @Test
    fun getNextIncQuestionAnswerRef() {
        val allQuestions = AllQuestions()
        var currentQuestion = 0
        val nextQuestion = NextQuestion()

        Assert.assertEquals(allQuestions.allQuestions[currentQuestion].answer, true)
        currentQuestion += 1
        Assert.assertEquals(allQuestions.allQuestions[currentQuestion].answer, true)
        currentQuestion += 1
        Assert.assertEquals(allQuestions.allQuestions[currentQuestion].answer, false)
    }
}
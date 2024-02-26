package com.example.k2024_02_06_quiz_start

import com.example.k2024_02_06_quiz_start.model.AllQuestions
import com.example.k2024_02_06_quiz_start.controller.NextQuestion
import com.example.k2024_02_06_quiz_start.model.Score

import org.junit.Test
import org.junit.Assert.assertEquals

class ScoreTests {
    @Test
    fun incrementScore_valid() {
        val score = Score()

        assertEquals(0, score.getScore())
        score.incrementScore()
        assertEquals(1, score.getScore())
        score.incrementScore()
        assertEquals(2, score.getScore())
    }

    @Test
    fun getScore_initial() {
        val score = Score()

        assertEquals(0, score.getScore())
    }

    @Test
    fun questionScore_increment() {
        val score = Score()
        val allQuestions = AllQuestions()
        val nextQuestion = NextQuestion()
        var questionNumber = nextQuestion.getNextIncQuestionNumber()
        var question = allQuestions.getQuestion(questionNumber)

        if (question.answer == true) {
            score.incrementScore()
        }

        assertEquals(1, score.getScore())

    }
}
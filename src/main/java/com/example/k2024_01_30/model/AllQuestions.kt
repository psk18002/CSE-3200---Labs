package com.example.k2024_01_30.model

class AllQuestions {

    val allQuestions = arrayOf(
        Question<Boolean>("Jupiter is the largest planet in our solar system.", true, Difficulty.EASY),
        Question<Boolean>("Saturn is the largest planet in our solar system.", false, Difficulty.EASY),
        Question<Int>("What year was the United States formed?", 1776, Difficulty.EASY),
        Question<String>("Who is the composer of Caprice No. 24?", "Nicolo Paganini", Difficulty.HARD),
        Question<Int>("What year was UConn founded?", 1861, Difficulty.MEDIUM),
        Question<String>("The highest award in computing is named after Alan T_____.", "Turing", Difficulty.MEDIUM),
        Question<String>("What is the capital of Connecticut?", "Hartford", Difficulty.EASY)
    )

    fun totalQuestions() : Int {
        return allQuestions.size
    }
}
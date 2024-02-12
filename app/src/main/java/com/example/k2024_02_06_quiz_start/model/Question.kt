package com.example.k2024_02_06_quiz_start.model

data class Question<T> (
    val questionText : String,
    val answer : T,
    val difficulty: Difficulty
)
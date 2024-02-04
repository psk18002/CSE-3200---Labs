package com.example.k2024_01_30.model

data class Question<T> (
    val questionText : String,
    val answer : T,
    val difficulty: Difficulty
    )
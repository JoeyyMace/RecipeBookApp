package com.example.myapplication.data

data class Recipe(
    val name: String,
    val prepTime: String,
    val calories: String,
    val ingredients: List<String>,
    val imageResId: Int // or a URL if loading from network
)

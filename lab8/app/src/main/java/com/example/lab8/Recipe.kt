package com.example.lab8

data class Recipe(
    val idMeal: String,
    val strMeal:String,
    val strMealThumb:String
)

data class RecipeResponse(val meals: List<Recipe>)
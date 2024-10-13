package com.example.lab9

data class Recipe(
    val idMeal: String,
    val strMeal:String,
    val strMealThumb:String
)

data class RecipeResponse(val meals: List<Recipe>)
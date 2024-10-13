package com.example.lab9

data class DetailRecipe(
    val idMeal: String,
    val strMeal: String,
    val strMealThumb: String,
    val strInstructions: String,
    val strCategory: String,
    val strArea: String
)


data class DetailResponse(val meals: List<DetailRecipe>)

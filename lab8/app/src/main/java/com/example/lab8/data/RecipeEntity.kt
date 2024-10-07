package com.example.lab8.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.lab8.DetailRecipe
import com.example.lab8.Recipe

@Entity(tableName = "recipes")
data class RecipeEntity(
    @PrimaryKey val idMeal: String,
    val strMeal: String,
    val strMealThumb: String,
    val strInstructions: String?,
    @ColumnInfo(name = "strCategory") val strCategory: String // Importante el nombre correcto
) {
    fun toRecipe() = Recipe(
        idMeal = idMeal,
        strMeal = strMeal,
        strMealThumb = strMealThumb
    )

    fun toDetailRecipe() = DetailRecipe(
        idMeal = idMeal,
        strMeal = strMeal,
        strMealThumb = strMealThumb,
        strInstructions = strInstructions ?: "",
        strCategory = strCategory
    )

    companion object {
        fun fromRecipe(recipe: Recipe, category: String) = RecipeEntity(
            idMeal = recipe.idMeal,
            strMeal = recipe.strMeal,
            strMealThumb = recipe.strMealThumb,
            strInstructions = null,
            strCategory = category
        )

        fun fromRecipeDetail(recipe: DetailRecipe) = RecipeEntity(
            idMeal = recipe.idMeal,
            strMeal = recipe.strMeal,
            strMealThumb = recipe.strMealThumb,
            strInstructions = recipe.strInstructions,
            strCategory = recipe.strCategory
        )
    }
}




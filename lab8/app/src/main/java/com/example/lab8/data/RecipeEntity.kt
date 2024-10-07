package com.example.lab8.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.lab8.Recipe

@Entity(tableName = "recipe")
data class RecipeEntity(
    @PrimaryKey val idMeal: String,
    val strMeal: String,
    val strMealThumb: String,
)

// Funciones de conversión entre Recipe y RecipeEntity
fun Recipe.toRecipeEntity(): RecipeEntity {
    return RecipeEntity(
        idMeal = this.idMeal,
        strMeal = this.strMeal,
        strMealThumb = this.strMealThumb
    )
}

fun RecipeEntity.toRecipe(): Recipe {
    return Recipe(
        idMeal = this.idMeal,
        strMeal = this.strMeal,
        strMealThumb = this.strMealThumb
    )
}


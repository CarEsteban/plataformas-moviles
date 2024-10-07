package com.example.lab8.data
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.OnConflictStrategy

@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipes(recipes: List<RecipeEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipe(recipe: RecipeEntity)

    @Query("SELECT * FROM recipes WHERE strCategory = :category") // Asegúrate de usar el nombre correcto
    suspend fun getRecipesByCategory(category: String): List<RecipeEntity>

    @Query("SELECT * FROM recipes WHERE idMeal = :idMeal")
    suspend fun getRecipeById(idMeal: String): RecipeEntity?
}



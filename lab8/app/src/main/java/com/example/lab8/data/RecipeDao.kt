package com.example.lab8.data
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.OnConflictStrategy

@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipe(recipe: RecipeEntity)

    @Query("SELECT * FROM recipe")
    suspend fun getAllRecipes(): List<RecipeEntity>

    @Query("SELECT * FROM recipe WHERE idMeal = :idMeal")
    suspend fun getRecipeById(idMeal: String): RecipeEntity?
}


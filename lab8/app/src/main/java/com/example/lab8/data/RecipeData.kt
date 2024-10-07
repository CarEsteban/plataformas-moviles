package com.example.lab8.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [RecipeEntity::class], version = 3)
abstract class RecipeData: RoomDatabase(){
    abstract fun recipeDao(): RecipeDao
}

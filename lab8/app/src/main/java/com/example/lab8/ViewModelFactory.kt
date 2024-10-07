package com.example.lab8

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lab8.data.RecipeDao

class MainViewModelFactory(
    private val recipeDao: RecipeDao,
    private val context: Context
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(recipeDao, context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}



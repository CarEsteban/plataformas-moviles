package com.example.lab8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.lab8.data.RecipeData

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializa la base de datos
        val db = Room.databaseBuilder(
            applicationContext,
            RecipeData::class.java, "recipe-db"
        ).build()
        val recipeDao = db.recipeDao()

        // Crea el ViewModelFactory y el ViewModel
        val viewModelFactory = MainViewModelFactory(recipeDao, this)
        val mainViewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        setContent {
            val navController = rememberNavController()

            // Usa el mainViewModel dentro de las composiciones
            NavHost(navController = navController, startDestination = "recipeList") {
                composable("recipeList") {
                    RecipeScreen(navController = navController, mainViewModel = mainViewModel)
                }
                composable("recipeDetail/{recipeId}") { backStackEntry ->
                    val recipeId = backStackEntry.arguments?.getString("recipeId") ?: ""
                    DetailRecipeScreen(recipeId = recipeId, mainViewModel = mainViewModel) {
                        navController.popBackStack()
                    }
                }
            }
        }
    }
}











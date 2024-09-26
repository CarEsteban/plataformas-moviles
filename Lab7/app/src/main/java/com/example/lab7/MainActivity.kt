package com.example.lab7

import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab7.ui.theme.Lab7Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab7Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavigationApp(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun NavigationApp(modifier: Modifier) {
    val navControlador = rememberNavController()

    NavHost(navController = navControlador, startDestination = "home") {
        composable("home") { Home(navControlador) }
        composable("loginPage") { LoginPage(navControlador) }
        composable("taskApp/{user}/{password}") { backStackEntry ->
            val user = backStackEntry.arguments?.getString("user")
            val password = backStackEntry.arguments?.getString("password")

            TaskApp(navControlador, user?: "", password?:"")
        }
        composable("settings/{tareasTerminadas}/{user}/{password}") { backStackEntry ->
            val tareasTerminadas = backStackEntry.arguments?.getString("tareasTerminadas")?.toInt()
            val user = backStackEntry.arguments?.getString("user")
            val password = backStackEntry.arguments?.getString("password")

            Settings(navControlador, tareasTerminadas,user?: "", password?:"")
        }
    }

}

package com.example.lab11

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab11.data.UserDataStore
import com.example.lab11.screens.CreatePostScreen
import com.example.lab11.screens.UserProfileScreen
import com.example.lab11.ui.theme.Lab11Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab11Theme {
                BlogApp()
            }
        }
    }
}

@Composable
fun BlogApp() {
    val navController = rememberNavController()
    val context = LocalContext.current
    val userDataStore = UserDataStore(context) // Usa el contexto aquí

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "user_profile",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("create_post") { CreatePostScreen() }
            composable("user_profile") {
                UserProfileScreen(userDataStore = userDataStore)
            }
        }
    }
}


@Composable
fun BottomNavigationBar(navController: NavController){
    Row (
        Modifier.padding(bottom = 60.dp)
    ){
        Button(onClick = {navController.navigate("create_post")}) {
            Text("Create Post")
        }
        Button(onClick = {navController.navigate("user_profile")}) {
            Text("Profile")
        }
    }
}
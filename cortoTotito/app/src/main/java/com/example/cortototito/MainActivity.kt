package com.example.cortototito

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cortototito.ui.theme.CortoTotitoTheme
import androidx.navigation.navArgument


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun App(){
    val navController = rememberNavController()
    Scaffold {

        NavHost(navController = navController, startDestination = "home") {
            composable("home") { Home(navController, modifier = Modifier) }
            composable(
                "tablero/{tableroNumero}",
                arguments = listOf(navArgument("tableroNumero") { type = NavType.IntType })
            ) { backStackEntry ->
                Tablero(
                    modifier = Modifier,
                    sizeTablero = backStackEntry.arguments?.getInt("tableroNumero") ?: 3,
                    navController
                )
            }
        }

    }
}

@Composable
fun Home(navController: NavController, modifier: Modifier) {
    Column (
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Tic Tac Toe",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        var jugador1 by remember { mutableStateOf("") }
        var jugador2 by remember { mutableStateOf("") }
        var tableroNumero by remember { mutableStateOf("") }

        TextField(
            value = jugador1,
            onValueChange = { jugador1 = it },
            label = { Text("Nombre del primer jugador") },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = jugador2,
            onValueChange = { jugador2 = it },
            label = { Text("Nombre del segundo jugador") },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = tableroNumero,
            onValueChange = { tableroNumero = it },
            label = { Text("Tamaño del tablero (3, 4, 5)") },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                // Asegúrate de que tableroNumero sea un entero válido antes de navegar
                tableroNumero.toIntOrNull()?.let {
                    navController.navigate("tablero/$it")
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Jugar")
        }

    }
}


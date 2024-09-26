package com.example.lab7

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Settings(navController: NavController, tareasTerminadas: Int?, user: String?, password: String?) {

    val tareasTerminadasValue = tareasTerminadas ?: 0

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF121212)), // Fondo negro suave
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Contador de tareas terminadas: $tareasTerminadasValue",
            color = Color(0xFFE0E0E0), // Texto principal gris claro
            fontSize = 24.sp
        )


        // Barra de navegación inferior
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFF121212))
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceAround // Distribuye los botones de manera equitativa
        ) {
            Button(
                onClick = { navController.navigate("taskApp/$user/1234") }, // Cambiar a la ruta taskApp
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF7043), // Fondo del botón anaranjado claro
                    contentColor = Color(0xFF121212) // Texto del botón negro suave
                )
            ) {
                Text("TaskApp")
            }

            Spacer(modifier = Modifier.width(16.dp)) // Espaciado entre los botones

            Button(
                onClick = { navController.navigate("settings/${tareasTerminadas}") }, // Cambiar a la ruta settings
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF7043), // Fondo del botón anaranjado claro
                    contentColor = Color(0xFF121212) // Texto del botón negro suave
                )
            ) {
                Text("Settings")
            }
        }

    }
}

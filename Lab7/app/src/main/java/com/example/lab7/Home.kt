package com.example.lab7

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
/*
// Colores del tema oscuro elegante
 BackgroundColor = Color(0xFF121212) // Fondo negro suave
 PrimaryTextColor = Color(0xFFE0E0E0) // Texto principal gris claro
 SecondaryTextColor = Color(0xFFBDBDBD) // Texto secundario gris medio
 ButtonBackgroundColor = Color(0xFFFF7043) // Fondo del botón anaranjado claro
 ButtonTextColor = Color(0xFF121212) // Texto del botón negro suave

*/
@Composable
fun Home(navController: NavController){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF121212)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .padding(bottom = 40.dp),
            color = Color(0xFFE0E0E0),
            text = "Task App Demo",
            fontSize = 30.sp
        )
        Button(
            onClick = { navController.navigate("loginPage") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF7043),
                contentColor = Color(0xFF121212)
            ),
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = "Iniciar Sesion",
            )
        }
    }
}
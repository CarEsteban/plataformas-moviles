package com.example.lab7

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LoginPage(navController: NavController){
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF121212)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login Page",
            color = Color(0xFFE0E0E0),
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 20.dp)
        )

        // Campo de texto para usuario
        BasicTextField(
            value = username.value,
            onValueChange = { username.value = it },
            textStyle = TextStyle(color = Color(0xFFE0E0E0), fontSize = 18.sp),
            modifier = Modifier
                .background(color = Color(0xFFBDBDBD))
                .padding(16.dp)
                .fillMaxWidth(0.8f)
        )

        // Espacio entre campos
        Spacer(modifier = Modifier.padding(8.dp))

        // Campo de texto para contraseña
        BasicTextField(
            value = password.value,
            onValueChange = { password.value = it },
            textStyle = TextStyle(color = Color(0xFFE0E0E0), fontSize = 18.sp),
            modifier = Modifier
                .background(color = Color(0xFFBDBDBD))
                .padding(16.dp)
                .fillMaxWidth(0.8f)
        )

        // Espacio entre campos
        Spacer(modifier = Modifier.padding(16.dp))

        Button(
            onClick = { navController.navigate("home") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF7043),
                contentColor = Color(0xFF121212)
            ),
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Regresar a la pantalla inicial")
        }

        Button(
            onClick = {
                navController.navigate("taskApp/${username.value}/${password.value}")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF7043),
                contentColor = Color(0xFF121212),
                disabledContainerColor = Color(0xFFFFAB91)
            ),
            enabled = username.value.isNotEmpty() && password.value.isNotEmpty(),
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Iniciar Sesion")
        }
    }
}

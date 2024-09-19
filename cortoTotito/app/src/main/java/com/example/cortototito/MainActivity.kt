package com.example.cortototito

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
import com.example.cortototito.ui.theme.CortoTotitoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CortoTotitoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //Home(modifier = Modifier.padding(innerPadding))
                    Tablero(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Home(modifier: Modifier = Modifier) {
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
        var tablero by remember { mutableStateOf("") }

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
            value = tablero,
            onValueChange = { tablero = it },
            label = { Text("Tamaño del tablero (3, 4, 5)") },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {  },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Jugar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CortoTotitoTheme {
        Home()
    }
}
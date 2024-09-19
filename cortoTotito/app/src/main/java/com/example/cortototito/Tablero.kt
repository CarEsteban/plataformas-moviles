package com.example.cortototito

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Tablero(modifier: Modifier = Modifier) {
    val tableroTamanio = 3

    Box(
        modifier = Modifier
            .fillMaxSize()  // Llena todo el espacio disponible
            .then(modifier),  // Aplica cualquier modificador adicional pasado al composable
        contentAlignment = Alignment.Center  // Centra el contenido (el LazyVerticalGrid) dentro del Box
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(tableroTamanio),  // Define 3 columnas
            contentPadding = PaddingValues(16.dp),  // Espaciado alrededor de la cuadrícula
            verticalArrangement = Arrangement.Center,  // Espaciado vertical entre filas
            horizontalArrangement = Arrangement.Center  // Espaciado horizontal entre columnas
        ) {
            items(tableroTamanio * tableroTamanio) { index ->
                Button(
                    onClick = {
                        // Define aquí la acción al hacer clic en el botón
                    },
                    modifier = Modifier
                        .size(100.dp)  // Tamaño fijo para cada celda
                        .padding(4.dp),  // Espaciado dentro del botón
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,  // Fondo del botón
                        contentColor = Color.Black  // Color del texto y otros elementos dentro del botón
                    ),
                    elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 5.dp)  // Elevación para efecto de sombra
                ) {
                    Text(
                        "",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}


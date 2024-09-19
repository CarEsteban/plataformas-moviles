package com.example.cortototito

import Ganador
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlin.random.Random


@Composable
fun Tablero(modifier: Modifier = Modifier, sizeTablero: Int , navController: NavController){

    var boardState by remember { mutableStateOf(List(sizeTablero * sizeTablero) { "" }) }
    var currentPlayer by remember {
        mutableStateOf(if (Random.nextBoolean()) "X" else "O")
    }
    var ganador by remember { mutableStateOf<String?>(null) }  // null indica que no hay ganador todavía

    if (ganador != null) {
        // Llamar a la composable de ganador si hay un ganador
        Ganador(navController, ganador!!)
    } else {
        Box(
            modifier = Modifier
                .fillMaxSize()  // Llena todo el espacio disponible
                .then(modifier),  // Aplica cualquier modificador adicional pasado al composable
            contentAlignment = Alignment.Center  // Centra el contenido (el LazyVerticalGrid) dentro del Box
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(sizeTablero),  // Define 3 columnas
                contentPadding = PaddingValues(16.dp),  // Espaciado alrededor de la cuadrícula
                verticalArrangement = Arrangement.Center,  // Espaciado vertical entre filas
                horizontalArrangement = Arrangement.Center  // Espaciado horizontal entre columnas
            ) {


                items(sizeTablero * sizeTablero) { index ->
                    Button(
                        onClick = {
                            if (boardState[index] == "") {
                                boardState = boardState.toMutableList().apply {
                                    this[index] = currentPlayer
                                }
                                if (verificacion(boardState, sizeTablero)) {
                                    ganador = currentPlayer  // Establece el jugador actual como ganador
                                } else {
                                    currentPlayer = if (currentPlayer == "X") "O" else "X"
                                }
                            }
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
                            text = boardState[index],
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            }
        }

        Button(
            onClick = {
                navController.navigate("home")

            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Regresar a Home")
        }
    }


}



fun verificacion(tablero: List<String>, size: Int): Boolean {
    // Verificar filas
    for (i in 0 until size) {
        for (j in 0..(size - 3)) {
            if (tablero[i * size + j] != "" &&
                tablero[i * size + j] == tablero[i * size + j + 1] &&
                tablero[i * size + j] == tablero[i * size + j + 2]) {
                return true
            }
        }
    }

    // Verificar columnas
    for (i in 0 until size) {
        for (j in 0..(size - 3)) {
            if (tablero[j * size + i] != "" &&
                tablero[j * size + i] == tablero[(j + 1) * size + i] &&
                tablero[j * size + i] == tablero[(j + 2) * size + i]) {
                return true
            }
        }
    }

    // Verificar diagonales principales (\)
    for (i in 0..(size - 3)) {
        for (j in 0..(size - 3)) {
            if (tablero[i * size + j] != "" &&
                tablero[i * size + j] == tablero[(i + 1) * size + j + 1] &&
                tablero[i * size + j] == tablero[(i + 2) * size + j + 2]) {
                return true
            }
        }
    }

    // Verificar diagonales secundarias (/)
    for (i in 0..(size - 3)) {
        for (j in 2 until size) {
            if (tablero[i * size + j] != "" &&
                tablero[i * size + j] == tablero[(i + 1) * size + j - 1] &&
                tablero[i * size + j] == tablero[(i + 2) * size + j - 2]) {
                return true
            }
        }
    }

    return false
}

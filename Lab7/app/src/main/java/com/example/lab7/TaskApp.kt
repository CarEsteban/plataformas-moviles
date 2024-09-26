package com.example.lab7

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun TaskApp(navController: NavController, user: String?, password: String?) {
    var tareasTerminadas by rememberSaveable { mutableIntStateOf(0) }
    var tareas = rememberSaveable { mutableStateListOf("") } // Lista de tareas

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF121212)), // Fondo negro suave
        verticalArrangement = Arrangement.SpaceAround, // Distribución entre elementos
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Bienvenido $user",
            color = Color(0xFFE0E0E0), // Texto principal gris claro
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )


        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(450.dp)
                .padding(16.dp)
        ) {
            items(tareas.size) { index ->
                TareaItem(
                    tarea = tareas[index],
                    onCheckedChange = { checked ->
                        if (checked) {
                            tareasTerminadas++
                        } else {
                            tareasTerminadas--
                        }
                    },
                    onTextChange = { newText ->
                        tareas[index] = newText
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            item {
                Button(
                    onClick = { tareas.add("") },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFF7043),
                        contentColor = Color(0xFF121212)
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Agregar Tarea")
                }
            }
        }

        // Barra de navegación inferior
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFF121212))
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceAround // Distribuye los botones de manera equitativa
        ) {
            Button(
                onClick = { navController.navigate("taskApp/$user/$password") }, // Cambiar a la ruta taskApp
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF7043), // Fondo del botón anaranjado claro
                    contentColor = Color(0xFF121212) // Texto del botón negro suave
                )
            ) {
                Text("TaskApp")
            }

            Spacer(modifier = Modifier.width(16.dp)) // Espaciado entre los botones

            Button(
                onClick = { navController.navigate("settings/$tareasTerminadas/$user/$password") }, // Cambiar a la ruta settings
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

@Composable
fun TareaItem(
    tarea: String,
    onCheckedChange: (Boolean) -> Unit,
    onTextChange: (String) -> Unit
) {
    var isChecked by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = { checked ->
                isChecked = checked
                onCheckedChange(checked)
            },
            colors = CheckboxDefaults.colors(
                checkmarkColor = Color(0xFF121212), // Color del checkmark
                uncheckedColor = Color(0xFFE0E0E0), // Color del borde cuando está desmarcado
                checkedColor = Color(0xFFFF7043) // Color cuando está marcado
            )
        )

        Spacer(modifier = Modifier.width(8.dp))

        BasicTextField(
            value = tarea,
            onValueChange = onTextChange,
            textStyle = TextStyle(color = Color(0xFFE0E0E0), fontSize = 18.sp),
            modifier = Modifier
                .background(Color(0xFFBDBDBD))
                .padding(8.dp)
                .fillMaxWidth()
        )
    }
}

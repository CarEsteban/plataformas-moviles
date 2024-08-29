package com.example.laboratorio5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.text.input.TextFieldValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ejemplos5()
        }
    }
}

@Composable
fun Ejemplos5() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        EditTextExample()
        Spacer(modifier = Modifier.height(16.dp))
        ButtonExample()
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumnExample()
        Spacer(modifier = Modifier.height(16.dp))
        TextExample()
        Spacer(modifier = Modifier.height(16.dp))
        CheckBoxExample()
    }
}

@Composable
fun EditTextExample() {
    var text by remember { mutableStateOf("Hola Mundo") }

    TextField(
        value = text,
        onValueChange = { text = it },
        modifier = Modifier.fillMaxWidth(),
        label = { Text("Ingrese texto") }
    )
}

@Composable
fun ButtonExample() {
    var counter by remember { mutableIntStateOf(0) }

    Button(onClick = { counter++ }) {
        Text(text = "Contador: $counter")
    }
}

@Composable
fun LazyColumnExample() {
    val items = List(100) { "Elemento $it" }

    LazyColumn(modifier = Modifier.fillMaxHeight(0.5f)) {
        items(items) { item ->
            Text(text = item, modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun TextExample() {
    Text(
        text = "Este es un texto simple",
        fontSize = 20.sp,
        modifier = Modifier.padding(8.dp)
    )
}

@Composable
fun CheckBoxExample() {
    var isChecked by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
        modifier = Modifier.padding(8.dp)
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = { isChecked = it }
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = if (isChecked) "Seleccionado" else "No seleccionado")
    }
}

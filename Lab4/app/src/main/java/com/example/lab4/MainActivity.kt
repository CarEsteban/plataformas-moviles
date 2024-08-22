package com.example.lab4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab4.ui.theme.Lab4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab4Theme {
                Calculadora()
            }
        }
    }
}

@Composable
fun Calculadora(modifier: Modifier = Modifier){

    var operacion by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("0") }

    Column {
        DisplayCalculadora(resultado, operacion)
        Row {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "X^y")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "√X")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "(")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = ")")
            }
        }
        Row {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "AC")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "DEL")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = ".")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "*")
            }
        }
        Row {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "7")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "8")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "9")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "/")
            }
        }
        Row {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "4")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "5")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "6")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "+")
            }
        }
        Row {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "1")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "2")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "3")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "-")
            }
        }
        Row {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "0")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "=")
            }
        }
    }
}

@Composable
fun DisplayCalculadora(operacion: String,resultado: String){
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column {
            Text(text = operacion)
            Text(text = resultado)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DisplayCalculadoraPreview(){
    DisplayCalculadora("operacion", "resultado")
}
package com.example.lab4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab4.ui.theme.Lab4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab4Theme {
                Column {
                    Row {
                        Text(text = "0") // Resultado
                    }
                    Row {
                        Button(onClick = { /*TODO*/ }) {
                            Text(text = "X^Y")
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
        }
    }
}

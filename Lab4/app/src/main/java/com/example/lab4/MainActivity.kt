package com.example.lab4

import com.example.lab4.OperarPostfix
import android.os.Bundle
import androidx.compose.ui.graphics.Color
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
fun Calculadora(
    modifier: Modifier = Modifier
        .fillMaxSize()
){

    var operacion by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ) {

        DisplayCalculadora(resultado, operacion)
        Column(
            modifier = Modifier
                .height(510.dp)
                .padding(bottom = 20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            BotonCustom(text = "x^y", onClick = { resultado += "^" }, modifier = Modifier)
            BotonCustom(text = "√X", onClick = { resultado += "√" }, modifier = Modifier)
            BotonCustom(text = "(", onClick = { resultado += "(" }, modifier = Modifier)
            BotonCustom(text = ")", onClick = { resultado += ")" }, modifier = Modifier)
        }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                BotonCustom(text = "AC", onClick = { resultado = "" }, modifier = Modifier)
                BotonCustom(text = "DEL", onClick = { resultado = resultado.dropLast(1) }, modifier = Modifier)
                BotonCustom(text = ".", onClick = {
                    val partes = resultado.split("+", "-", "*", "/")
                    val ultimaParte = partes.lastOrNull() ?: ""
                    if (!ultimaParte.contains(".")) {
                        resultado += "."
                    }
                }, modifier = Modifier)
                BotonCustom(text = "*", onClick = { resultado += "*" }, modifier = Modifier)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                BotonCustom(text = "7", onClick = { resultado += "7" }, modifier = Modifier)
                BotonCustom(text = "8", onClick = { resultado += "8" }, modifier = Modifier)
                BotonCustom(text = "9", onClick = { resultado += "9" }, modifier = Modifier)
                BotonCustom(text = "/", onClick = { resultado += "/" }, modifier = Modifier)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                BotonCustom(text = "4", onClick = { resultado += "4" }, modifier = Modifier)
                BotonCustom(text = "5", onClick = { resultado += "5" }, modifier = Modifier)
                BotonCustom(text = "6", onClick = { resultado += "6" }, modifier = Modifier)
                BotonCustom(text = "+", onClick = { resultado += "+" }, modifier = Modifier)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                BotonCustom(text = "1", onClick = { resultado += "1" }, modifier = Modifier)
                BotonCustom(text = "2", onClick = { resultado += "2" }, modifier = Modifier)
                BotonCustom(text = "3", onClick = { resultado += "3" }, modifier = Modifier)
                BotonCustom(text = "-", onClick = { resultado += "-" }, modifier = Modifier)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                BotonCustom(
                    text = "0",
                    onClick = { resultado += "0" },
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxSize()
                        .padding(end = 4.dp)
                )
                BotonCustom(
                    text = "=",
                    onClick = {

                        var postfix = Conversor.PostFixConversion(resultado)
                        if (postfix == "Error") {
                            operacion = "Error"
                        } else {
                            operacion = OperarPostfix(postfix).mostrarResultado()
                            resultado = ""
                        }
                    },
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxSize()
                        .padding(start = 4.dp)
                )
            }

        }
    }
}
@Composable
fun BotonCustom(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color.Black
        ),
        shape = RoundedCornerShape(12.dp),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 8.dp,
            pressedElevation = 12.dp,
            disabledElevation = 0.dp
        ),
        modifier = modifier
            .width(80.dp)
            .height(80.dp)
            .padding(bottom = 5.dp)
    ) {
        Text(text = text)
    }
}
@Composable
fun DisplayCalculadora(operacion: String, resultado: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp),
        shape = RoundedCornerShape(10.dp),  // Bordes redondeados
        elevation = CardDefaults.cardElevation(2.dp),  // Elevación usando CardDefaults
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFFF1E3))
                .padding(vertical = 30.dp)
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = resultado,
                modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp),
                textAlign = androidx.compose.ui.text.style.TextAlign.End,
                color = Color.DarkGray,  // Color gris para la operación
                fontSize = 20.sp  // Tamaño de texto más grande
            )
            Text(
                text = if (operacion.isEmpty()) "0" else operacion,
                modifier = Modifier.fillMaxWidth(),
                textAlign = androidx.compose.ui.text.style.TextAlign.End,
                color = Color.Gray,  // Color negro para el resultado
                fontSize = 36.sp,  // Tamaño más grande para el resultado
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold  // Negrita para resaltar
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DisplayCalculadoraPreview(){
    DisplayCalculadora("operacion", "resultado")
}

@Preview(showBackground = true)
@Composable
fun CalculadoraPreview(){
    Calculadora(modifier = Modifier)
}

class Conversor {
    companion object {
        // Método para convertir infix a postfix
        fun PostFixConversion(string: String): String {
            var resultado = "" // Variable que almacenará el resultado en notación postfix
            val stack = ArrayDeque<Char>() // Pila para manejar operadores y paréntesis
            var i = 0 // Índice para recorrer la cadena de entrada

            while (i < string.length) {
                val s = string[i] // Carácter actual

                if (s.isDigit()) { // Si el carácter es un dígito
                    resultado += s // Agregar el dígito al resultado
                    // Manejar números de múltiples dígitos
                    while (i + 1 < string.length && string[i + 1].isDigit()) {
                        resultado += string[i + 1] // Agregar dígitos adicionales al resultado
                        i++ // Avanzar el índice
                    }
                    resultado += " " // Agregar un espacio después del número
                } else if (s == '(') { // Si el carácter es un paréntesis de apertura
                    stack.push(s) // Empujar el paréntesis en la pila
                } else if (s == ')') { // Si el carácter es un paréntesis de cierre
                    // Desapilar y agregar al resultado hasta encontrar un paréntesis de apertura
                    while (stack.isNotEmpty() && stack.peek() != '(') {
                        resultado += "${stack.pop()} "
                    }
                    if (stack.isNotEmpty()) stack.pop() // Eliminar el paréntesis de apertura
                } else if (notNumeric(s)) { // Si el carácter es un operador
                    // Desapilar y agregar al resultado mientras el operador en la cima de la pila tenga mayor o igual precedencia
                    while (stack.isNotEmpty() && operatorPrecedence(s) <= operatorPrecedence(stack.peek()!!)) {
                        resultado += "${stack.pop()} "
                    }
                    stack.push(s) // Empujar el operador en la pila
                }
                i++ // Avanzar el índice
            }

            // Desapilar y agregar al resultado todos los operadores restantes en la pila
            while (stack.isNotEmpty()) {
                if (stack.peek() == '(') return "Error" // Si queda un paréntesis de apertura, hay un error en la expresión
                resultado += "${stack.pop()} "
            }
            return resultado.trim() // Devolver el resultado sin espacios adicionales al final
        }

        // Método para verificar si un carácter no es un dígito
        fun notNumeric(ch: Char): Boolean = when (ch) {
            '+', '-', '*', '/', '(', ')', '^', '√' -> true // Operadores y paréntesis no son numéricos
            else -> false // Cualquier otro carácter se considera numérico
        }

        // Método para determinar la precedencia de un operador
        fun operatorPrecedence(ch: Char): Int = when (ch) {
            '+', '-' -> 1 // Suma y resta tienen la precedencia más baja
            '*', '/' -> 2 // Multiplicación y división tienen precedencia intermedia
            '^', '√' -> 3 // La exponenciación y la raíz cuadrada tienen la precedencia más alta
            else -> -1 // Cualquier otro carácter tiene precedencia inválida
        }

        // Funciones de extensión
        fun <T> ArrayDeque<T>.push(element: T) = addLast(element)
        fun <T> ArrayDeque<T>.pop() = removeLastOrNull()
        fun <T> ArrayDeque<T>.peek() = lastOrNull()
    }
}
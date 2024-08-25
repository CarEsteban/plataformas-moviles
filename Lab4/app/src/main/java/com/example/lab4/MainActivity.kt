package com.example.lab4


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
    var resultado by remember { mutableStateOf("0") }

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
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                BotonCustom(text = "X^y", onClick = { /*TODO*/ },modifier = Modifier)
                BotonCustom(text = "√X", onClick = { /*TODO*/ },modifier = Modifier)
                BotonCustom(text = "(", onClick = { /*TODO*/ },modifier = Modifier)
                BotonCustom(text = ")", onClick = { /*TODO*/ },modifier = Modifier)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                BotonCustom(text = "AC", onClick = { /*TODO*/ },modifier = Modifier)
                BotonCustom(text = "DEL", onClick = { /*TODO*/ },modifier = Modifier)
                BotonCustom(text = ".", onClick = { /*TODO*/ },modifier = Modifier)
                BotonCustom(text = "*", onClick = { /*TODO*/ },modifier = Modifier)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            )  {
                BotonCustom(text = "7", onClick = { /*TODO*/ },modifier = Modifier)
                BotonCustom(text = "8", onClick = { /*TODO*/ },modifier = Modifier)
                BotonCustom(text = "9", onClick = { /*TODO*/ },modifier = Modifier)
                BotonCustom(text = "/", onClick = { /*TODO*/ },modifier = Modifier)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            )  {
                BotonCustom(text = "4", onClick = { /*TODO*/ },modifier = Modifier)
                BotonCustom(text = "5", onClick = { /*TODO*/ },modifier = Modifier)
                BotonCustom(text = "6", onClick = { /*TODO*/ },modifier = Modifier)
                BotonCustom(text = "+", onClick = { /*TODO*/ },modifier = Modifier)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            )  {
                BotonCustom(text = "1", onClick = { /*TODO*/ },modifier = Modifier)
                BotonCustom(text = "2", onClick = { /*TODO*/ },modifier = Modifier)
                BotonCustom(text = "3", onClick = { /*TODO*/ },modifier = Modifier)
                BotonCustom(text = "-", onClick = { /*TODO*/ },modifier = Modifier)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            )  {
                BotonCustom(
                    text = "0",
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxSize()
                        .padding(end = 4.dp)

                )
                BotonCustom(
                    text = "=",
                    onClick = { /*TODO*/ },
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
                .padding(16.dp),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = operacion,
                modifier = Modifier.fillMaxWidth(),
                textAlign = androidx.compose.ui.text.style.TextAlign.End,
                color = Color.DarkGray,  // Color gris para la operación
                fontSize = 20.sp  // Tamaño de texto más grande
            )
            Text(
                text = resultado,
                modifier = Modifier.fillMaxWidth(),
                textAlign = androidx.compose.ui.text.style.TextAlign.End,
                color = Color.Gray,  // Color negro para el resultado
                fontSize = 36.sp,  // Tamaño más grande para el resultado
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold  // Negrita para resaltar
            )
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
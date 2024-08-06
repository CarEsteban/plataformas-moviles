package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // TextViews
        val operacion = findViewById<TextView>(R.id.operacion)
        val resultado = findViewById<TextView>(R.id.resultado)

        // Botones de la primera fila
        val btnPotencia = findViewById<Button>(R.id.btn_potencia)
        val btnRaiz = findViewById<Button>(R.id.btn_raiz)
        val btnParentesisAbierto = findViewById<Button>(R.id.btn_parentesis_abierto)
        val btnParentesisCerrado = findViewById<Button>(R.id.btn_parentesis_cerrado)

        // Botones de la segunda fila
        val btnBorrarTodo = findViewById<Button>(R.id.btn_borrar_todo)
        val btnBorrarUno = findViewById<Button>(R.id.btn_borrar_uno)
        val btnDivision = findViewById<Button>(R.id.btn_division)
        val btnMultiplicacion = findViewById<Button>(R.id.btn_multiplicacion)

        // Botones de la tercera fila
        val btn7 = findViewById<Button>(R.id.btn_7)
        val btn8 = findViewById<Button>(R.id.btn_8)
        val btn9 = findViewById<Button>(R.id.btn_9)
        val btnResta = findViewById<Button>(R.id.btn_resta)

        // Botones de la cuarta fila
        val btn4 = findViewById<Button>(R.id.btn_4)
        val btn5 = findViewById<Button>(R.id.btn_5)
        val btn6 = findViewById<Button>(R.id.btn_6)
        val btnSuma = findViewById<Button>(R.id.btn_suma)

        // Botones de la quinta fila
        val btn1 = findViewById<Button>(R.id.btn_1)
        val btn2 = findViewById<Button>(R.id.btn_2)
        val btn3 = findViewById<Button>(R.id.btn_3)
        val btnIgual = findViewById<Button>(R.id.btn_igual)

        // Botones de la sexta fila
        val btn0 = findViewById<Button>(R.id.btn_0)
        val btnPunto = findViewById<Button>(R.id.btn_punto)

        if (btn7.callOnClick()){
            resultado.text = "$resultado + ${btn7.text}"
        }

    }
}

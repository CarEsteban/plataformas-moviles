package com.example.calculator

import OperarPostfix
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var primeraVez = true

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

        // Función para agregar texto al TextView resultado
        fun agregarTexto(texto: String) {
            if (primeraVez) {
                resultado.text = ""
                primeraVez = false
            }
            resultado.text = resultado.text.toString() + texto
        }

        // Asignar OnClickListeners a cada botón
        btnPotencia.setOnClickListener { agregarTexto("^") }
        btnRaiz.setOnClickListener { agregarTexto("√") }
        btnParentesisAbierto.setOnClickListener { agregarTexto("(") }
        btnParentesisCerrado.setOnClickListener { agregarTexto(")") }
        btnBorrarTodo.setOnClickListener {
            resultado.text = ""
            primeraVez = true
        }
        btnBorrarUno.setOnClickListener {
            val textoActual = resultado.text.toString()
            if (textoActual.isNotEmpty()) {
                resultado.text = textoActual.substring(0, textoActual.length - 1)
            }
        }
        btnDivision.setOnClickListener { agregarTexto("/") }
        btnMultiplicacion.setOnClickListener { agregarTexto("*") }
        btn7.setOnClickListener { agregarTexto("7") }
        btn8.setOnClickListener { agregarTexto("8") }
        btn9.setOnClickListener { agregarTexto("9") }
        btnResta.setOnClickListener { agregarTexto("-") }
        btn4.setOnClickListener { agregarTexto("4") }
        btn5.setOnClickListener { agregarTexto("5") }
        btn6.setOnClickListener { agregarTexto("6") }
        btnSuma.setOnClickListener { agregarTexto("+") }
        btn1.setOnClickListener { agregarTexto("1") }
        btn2.setOnClickListener { agregarTexto("2") }
        btn3.setOnClickListener { agregarTexto("3") }
        btnIgual.setOnClickListener {

            val textoOperar = resultado.text.toString();

            operacion.text = textoOperar;

            val operacionPostfix = Conversor.PostFixConversion(textoOperar)
            if (operacionPostfix == "Error") {
                resultado.text = "Error:404"
            } else {
                val resultadoOperacion = OperarPostfix(operacionPostfix)
                resultado.text = resultadoOperacion.mostrarResultado()
            }

            primeraVez = true



        }
        btn0.setOnClickListener { agregarTexto("0") }
        btnPunto.setOnClickListener { agregarTexto(".") }
    }
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
            '+', '-', '*', '/', '(', ')', '^' -> true // Operadores y paréntesis no son numéricos
            else -> false // Cualquier otro carácter se considera numérico
        }

        // Método para determinar la precedencia de un operador
        fun operatorPrecedence(ch: Char): Int = when (ch) {
            '+', '-' -> 1 // Suma y resta tienen la precedencia más baja
            '*', '/' -> 2 // Multiplicación y división tienen precedencia intermedia
            '^' -> 3 // La exponenciación tiene la precedencia más alta
            else -> -1 // Cualquier otro carácter tiene precedencia inválida
        }

        // Funciónes de extensión
        fun <T> ArrayDeque<T>.push(element: T) = addLast(element)
        fun <T> ArrayDeque<T>.pop() = removeLastOrNull()
        fun <T> ArrayDeque<T>.peek() = lastOrNull()
    }
}
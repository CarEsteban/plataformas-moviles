import java.util.*

class OperarPostfix(private val operacion: String) {
    private val caracteres = operacion.trim().split(" ")
    private val stack = Stack<Double>() // Cambiar a Double para manejar operaciones con raíz cuadrada y otras operaciones con decimales

    fun mostrarResultado(): String {
        for (char in caracteres) {
            if (char.toDoubleOrNull() != null) {
                stack.push(char.toDouble())
            } else {
                val operandoB = stack.pop() // Notar el cambio del orden de los operandos
                val operandoA = if (char != "√") stack.pop() else 0.0

                when (char) {
                    "+" -> stack.push(sumar(operandoA, operandoB))
                    "-" -> stack.push(restar(operandoA, operandoB))
                    "*" -> stack.push(multiplicar(operandoA, operandoB))
                    "/" -> stack.push(dividir(operandoA, operandoB))
                    "^" -> stack.push(potencia(operandoA, operandoB))
                    "√" -> stack.push(raizCuadrada(operandoB)) // Solo necesita un operando
                }
            }
        }
        return stack.peek().toString()
    }

    private fun sumar(a: Double, b: Double): Double = a + b
    private fun restar(a: Double, b: Double): Double = a - b
    private fun multiplicar(a: Double, b: Double): Double = a * b
    private fun dividir(a: Double, b: Double): Double = a / b
    private fun potencia(a: Double, b: Double): Double = Math.pow(a, b)
    private fun raizCuadrada(a: Double): Double = Math.sqrt(a)
}

fun main() {
    println("1) Problema 1\n2) Problema 2")
    val problema = readLine()
    val problemaValor = problema?.toIntOrNull()
    when (problemaValor) {
        1 -> problema1()
        2 -> problema2()
    }
}


fun problema1() {
    println("Problema 1")
    println("Ingrese el valor a convertir de decimal a binario:")
    val valor = readLine()
    val valorInt = valor?.toIntOrNull()

    if (valorInt == null) {
        println("Ingrese un valor válido")
        return
    }

    while (valorInt >0){
        var modulo = valorInt%2

        println(modulo)
        valorInt/2
    }


}
fun problema2() {
    println("Problema 2")
}
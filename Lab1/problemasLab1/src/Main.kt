fun main() {
    var continuar:Boolean = true
    while (continuar)   {
        println("1) Problema 1\n2) Problema 2")
        val problema = readLine()
        val problemaValor = problema?.toIntOrNull()
        when (problemaValor) {
            1 -> {
                problema1()
                continuar=repetirMenu()
            }
            2 -> {
                problema2()
                continuar=repetirMenu()
            }
        }
    }
}


fun problema1() {
    println("Problema 1")
    println("Ingrese el valor a convertir de decimal a binario:")
    val valor = readLine()
    var valorInt = valor?.toInt()
    var modulo:Int
    val arrayBinario:MutableList<Int> = mutableListOf()

    if (valorInt == null || valorInt <= 0) {
        println("Ingrese un valor válido y positivo")
        return
    }

    while (valorInt > 0){
        modulo = valorInt%2
        arrayBinario.add(modulo)
        valorInt /= 2
    }

    arrayBinario.reverse()
    println(arrayBinario.toString())
}

fun problema2() {
    println("Problema 2")
}

fun repetirMenu(): Boolean {
    println("Desea regresar al menú? 1)Si 2)No")
    var opcion = readLine()
    var opcionInt = opcion?.toInt()
    if (opcionInt == null){
        println("Ingrese un número válido")
    }else if(opcionInt == 1){
        return true
    }else if(opcionInt == 2){
        return false
    }
    return false
}
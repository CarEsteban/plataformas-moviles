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
    println("Programa de las palabras palíndromas")
    var continuar2:Boolean = true
    val arrayPalabras:MutableList<String> = mutableListOf()
    var contadorPalabrasPalindromas:Int = 0
    var contadorPalabrasVocales:Int = 0
    var contadorPalabrasConsonante:Int = 0

    while (continuar2){
        println("Ingrese la palabra:")
        var palabra = readLine()
        if (palabra != null) {
            arrayPalabras.add(palabra)
        }
        println("Desea ingresar otra palabra? 1)Si 2)No")
        var opcion = readLine()
        var opcionInt = opcion?.toInt()
        if (opcionInt == null){
            println("Ingrese un número válido")
        }else if(opcionInt == 1){
            continuar2 = true
        }else if(opcionInt == 2){
            continuar2 = false
        }
    }
    //bucle para contar las palabras palíndromas
    for (palabra in arrayPalabras){
        val palabraLimpia = palabra.trim().replace("\\s".toRegex(), "").lowercase()
        if (palabraLimpia.equals(palabraLimpia.reversed())){
            contadorPalabrasPalindromas++
        }
    }

    //bucle para contar las palabras que contienen al menos 2 vocales distintas
    val arrayVocales = setOf("a","e","i","o","u")
    for (palabra in arrayPalabras){
        for (char in palabra) {
            
        }
    }


    //bucle para contar las palabras que inician con una letra consonante


    println("Array de palabras ingresado: $arrayPalabras")
    println("Cantidad de palabras palíndromas del array: $contadorPalabrasPalindromas")
    println("Cantidad de palabras que contiene al menos 2 vocales distintas: $contadorPalabrasVocales")
    println("Cantidad de palabras que inician con una letra consonante: $contadorPalabrasConsonante")

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
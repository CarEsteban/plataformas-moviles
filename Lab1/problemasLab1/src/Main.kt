fun main() {
    var continuar = true
    while (continuar)   {
        println("1) Problema 1\n2) Problema 2")
        val problema = readlnOrNull()
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
    val valor = readlnOrNull()
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
    var continuar2 = true
    val arrayPalabras:MutableList<String> = mutableListOf()
    var contadorPalabrasPalindromas = 0
    var contadorPalabrasVocales = 0
    var contadorPalabrasConsonante = 0

    while (continuar2){
        println("Ingrese la palabra:")
        val palabra = readlnOrNull()
        if (palabra != null) {
            arrayPalabras.add(palabra)
        }
        println("Desea ingresar otra palabra? 1)Si 2)No")
        val opcion = readlnOrNull()
        val opcionInt = opcion?.toInt()
        when (opcionInt) {
            null -> println("Ingrese un número válido")
            1 -> continuar2 = true
            2 -> continuar2 = false
            else -> println("Opción no válida")
        }

    }
    //bucle para contar las palabras palíndromas
    for (palabra in arrayPalabras){
        val palabraLimpia = palabra.trim().replace("\\s".toRegex(), "").lowercase()
        if (palabraLimpia == palabraLimpia.reversed()){
            contadorPalabrasPalindromas++
        }
    }

    //bucle para contar las palabras que contienen al menos 2 vocales distintas
    val arrayVocales = setOf('a', 'e', 'i', 'o', 'u')
    for (palabra in arrayPalabras){
        val vocalesEncontradas = mutableSetOf<Char>()

        for (char in palabra.lowercase()) {
            if (char in arrayVocales) {
                vocalesEncontradas.add(char)
            }
        }

        if (vocalesEncontradas.size >= 2) {
            contadorPalabrasVocales++
        }
    }


    //bucle para contar las palabras que inician con una letra consonante
    val arrayConsonantes = setOf(
        'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p',
        'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'
    )
    for (palabra in arrayPalabras){
        val charArray = palabra.toCharArray()
        if (charArray[0] in arrayConsonantes){
            contadorPalabrasConsonante++
        }
    }

    println("Array de palabras ingresado: $arrayPalabras")
    println("Cantidad de palabras palíndromas del array: $contadorPalabrasPalindromas")
    println("Cantidad de palabras que contiene al menos 2 vocales distintas: $contadorPalabrasVocales")
    println("Cantidad de palabras que inician con una letra consonante: $contadorPalabrasConsonante")

}

fun repetirMenu(): Boolean {
    println("Desea regresar al menú? 1)Si 2)No")
    val opcion = readlnOrNull()
    val opcionInt = opcion?.toIntOrNull()

    return when (opcionInt) {
        null -> {
            println("Ingrese un número válido")
            false
        }
        1 -> true
        2 -> false
        else -> {
            println("Opción no válida")
            false
        }
    }
}

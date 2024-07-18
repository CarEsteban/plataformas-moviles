import java.util.*    // required import

fun main() {
    println(1+1)
    //⇒ res8: kotlin.Int = 2

    println(53-3)
    //⇒ res9: kotlin.Int = 50

    println(50/10)
    //⇒ res10: kotlin.Int = 5

    println(1.0/2.0)
    //⇒ res11: kotlin.Double = 0.5

    println(2.0*3.5)
    //⇒ res12: kotlin.Double = 7.0

    val i: Int = 6

    val b1 = i.toByte()
    println(b1)

    val b2: Byte = 1 // OK, literals are checked statically
    println(b2)
    //⇒ 1

/*  DAN ERROR
    val i1: Int = b2
    //⇒ error: type mismatch: inferred type is Byte but Int was expected

    val i2: String = b2
    //⇒ error: type mismatch: inferred type is Byte but String was expected

    val i3: Double = b2
    //⇒ error: type mismatch: inferred type is Byte but Double was expected
*/
    val i4: Int = b2.toInt() // OK!
    println(i4)
    //⇒ 1

    val i5: String = b2.toString()
    println(i5)
    //⇒ 1

    val i6: Double = b2.toDouble()
    println(i6)
    //⇒ 1.0

    val numberOfFish = 5
    val numberOfPlants = 12
    println("I have $numberOfFish fish and $numberOfPlants plants")
    println("I have ${numberOfFish + numberOfPlants} fish and plants")

    val fish = 50
    if (fish in 1..100) {
        println(fish)
    }

    println("other code")
    var fishFoodTreats:Int? = 6
    fishFoodTreats = fishFoodTreats?.dec() ?: 0
    println(fishFoodTreats)

    val school = listOf("mackerel", "trout", "halibut")
    println(school)

    val myList = mutableListOf("tuna", "salmon", "shark")
    myList.remove("shark")
    myList.add("tiburoncin")
    println(myList)

    val school2 = arrayOf("shark", "salmon", "minnow")
    println(school2.contentToString())

    val mix = arrayOf("fish", 2)
    println(mix.contentToString())


    val numbers = intArrayOf(1,2,3)
    val numbers3 = intArrayOf(4,5,6)
    val foo2 = numbers3 + numbers
    println(foo2.contentToString())

    val numbers1 = intArrayOf(1, 2, 3)
    val oceans = listOf("Atlantic", "Pacific")
    val oddList = listOf(numbers1, oceans, "salmon")
    val oddList2 = listOf(numbers1.contentToString(), oceans, "salmon")
    println(oddList)
    println(oddList2)
                                //it funcina como iterador
    val array = Array (5) { it * 2 }
    println(array.contentToString())

    val school3 = arrayOf("shark", "salmon", "minnow")
    for (element in school3) {
        print(element + " ")
    }

    println()

    for ((index, element) in school3.withIndex()) {
        println("Item at $index is $element")
    }

    for (i in 1..5) println(i)
    //⇒ 12345

    for (i in 5 downTo 1) println(i)
    //⇒ 54321

    for (i in 3..6 step 2) println(i)
    //⇒ 35

    for (i in 'd'..'g') println(i)
    //⇒ defg

    var bubbles = 0
    while (bubbles < 50) {
        bubbles++
    }
    println("$bubbles bubbles in the water\n")

    do {
        bubbles--
    } while (bubbles > 50)
    println("$bubbles bubbles in the water\n")

    repeat(2) {
        println("A fish is swimming")
    }

    feedTheFish()
    println(isTooHot(34))

    val decorations = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot","anastacio")
    println( decorations.filter {it[0] == 'a'})

    val decorations2 = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

    // eager, creates a new list
    val eager = decorations2.filter { it [0] == 'p' }
    println("eager: $eager")

    // lazy, will wait until asked to evaluate
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println("filtered: $filtered")

    val lazyMap = decorations.asSequence().map {
        println("access: $it")
        it
    }
    println("lazy: $lazyMap")
    println("-----")
    println("first: ${lazyMap.first()}")
    println("-----")
    println("all: ${lazyMap.toList()}")

    var dirtyLevel = 20
    val waterFilter = { sucia : Int -> sucia / 2}
    println(waterFilter(dirtyLevel))

}

fun feedTheFish() {
    val day = randomDay()
    val food = "pellets"
    println ("Today is $day and the fish eat $food")
}

fun randomDay() : String {
    val week = arrayOf ("Monday", "Tuesday", "Wednesday", "Thursday",
        "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(week.size)]
}

fun isTooHot(temperature: Int) = temperature > 30

fun isDirty(dirty: Int) = dirty > 30

fun isSunday(day: String) = day == "Sunday"
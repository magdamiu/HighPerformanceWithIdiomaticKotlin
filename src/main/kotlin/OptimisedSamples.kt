import Color.BLUE
import Color.YELLOW
import Color.ORANGE
import Color.INDIGO
import Color.GREEN
import Color.RED
import Color.VIOLET

enum class Color {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

fun mix(c1: Color, c2: Color) =
    when (setOf(c1, c2)) {
        setOf(RED, YELLOW) -> ORANGE
        setOf(YELLOW, BLUE) -> GREEN
        setOf(BLUE, Color.VIOLET) -> INDIGO
        else -> throw Exception("Not actually a color")
    }

fun mixOptimized(c1: Color, c2: Color) =
    when {
        (c1 == RED && c2 == YELLOW) ||
                (c1 == YELLOW && c2 == RED) ->
            ORANGE

        (c1 == YELLOW && c2 == BLUE) ||
                (c1 == BLUE && c2 == YELLOW) ->
            GREEN

        (c1 == BLUE && c2 == VIOLET) ||
                (c1 == VIOLET && c2 == BLUE) ->
            INDIGO

        else -> throw Exception("Dirty color")
    }


/*fun <T: Comparable<T>> Iterable<T>.countMin(): Int =
    count { it == this.minOrNull() }*/

fun <T: Comparable<T>> Iterable<T>.countMin(): Int {
    val minValue = this.minOrNull()
    return count { it == minValue }
}



inline fun <reified T> printTypeName() {
    println(T::class.simpleName)
}

fun main() {
    printTypeName<Int>()    // Int
    printTypeName<Char>()   // Char
    printTypeName<String>() // String

    println(Int::class.simpleName) // Int
    println(Char::class.simpleName) // Char
    println(String::class.simpleName) // String

   /* val any = Any()
    any is List<Int> // compilation error
    any is List<*> // OK*/
}



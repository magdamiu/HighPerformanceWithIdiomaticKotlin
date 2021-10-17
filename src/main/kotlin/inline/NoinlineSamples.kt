package inline

inline fun computeValues(
    number: Int, doubleValue: (number: Int) -> Unit,
    noinline tripleValue: (number: Int) -> Unit
) {
    doubleValue.invoke(number)
    tripleValue.invoke(number)
}

fun main() {
    val number = 7;
    computeValues(number,
        { println(doubleOfNumber(number)) },
        { println(tripleOfNumber(number)) })
}

fun doubleOfNumber(number: Int) = 2 * number

fun tripleOfNumber(number: Int) = 3 * number
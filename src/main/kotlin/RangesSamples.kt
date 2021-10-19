fun main(args: Array<String>) {
    val int = args[0].toInt()
    if (int in 0..10) {
        println(int)
    }

    val value = args[0].toIntOrNull()
    if (value in 0..10) {
        println(value)
    }
}
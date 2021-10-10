fun main() {
    // function types
    val sum: (Int, Int) -> (Int) = { a, b -> a + b }
    val printPIValue: () -> Unit = { println(Math.PI) }
}
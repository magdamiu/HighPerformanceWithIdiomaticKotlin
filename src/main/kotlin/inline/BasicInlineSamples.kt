package inline

class BasicInlineSamples {
    fun operation(op: () -> Unit) {
        println("Before calling op()")
        op()
        println("After calling op()")
    }
}

fun main() {
    val basicInlineSamples = BasicInlineSamples()
    basicInlineSamples.operation { println("This is the actual op function") }
}
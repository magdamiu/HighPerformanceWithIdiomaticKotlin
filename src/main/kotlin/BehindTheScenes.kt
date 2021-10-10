fun main() {
    initialCapturingMutableVariable()
    simplifiedCapturingMutableVariable()
    capturingImmutableVariable()
}

class Ref<T>(var value: T)

fun initialCapturingMutableVariable() {
    val counter = Ref(0)
    val incrementAction = { counter.value++ }
    incrementAction()
    println(counter.value)
}

fun simplifiedCapturingMutableVariable() {
    var counter = 0;
    val incrementAction = {
        counter++
    }
    incrementAction()
    println(counter)
}

private fun capturingImmutableVariable() {
    val counter = 100;
    val incrementAction = {
        println("$counter is the current value")
    }
    incrementAction()
}


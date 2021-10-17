import java.util.*

interface ValueHolder<V> {
    val value: V
}

class IntHolder : ValueHolder<Int> {
    override val value: Int
        get() = Random().nextInt()
}

fun main() {
    val sample = IntHolder()
    println(sample.value) //260078462
    println(sample.value) //1657381068
}
import java.util.concurrent.TimeUnit
import kotlin.system.measureNanoTime

fun main() {
/*    println("list")
    measure { list() } // 60ms
    println("sequence")
    measure { sequence() } // 6ms*/

    println("list")
    measure { smallList() } // 13ms
    println("sequence")
    measure { smallSequence() } // 7ms
}

fun measure(block: () -> Unit) {
    val nanoTime = measureNanoTime(block)
    val millis = TimeUnit.NANOSECONDS.toMillis(nanoTime)
    println("$millis ms")
}

fun list() = (0..1_000_000)
    .filter { it % 2 == 0 }
    .map { it * it }
    .first()

fun sequence() = (0..1_000_000)
    .asSequence()
    .filter { it % 2 == 0 }
    .map { it * it }
    .first()


fun smallList() = (0..5)
    .filter { print("list filter($it) "); it % 2 == 0 }
    .map { print("list map($it) "); it * it }
    .first()

fun smallSequence() = (0..5)
    .asSequence()
    .filter { print("seq filter($it) "); it % 2 == 0 }
    .map { print("seq map($it) "); it * it }
    .first()
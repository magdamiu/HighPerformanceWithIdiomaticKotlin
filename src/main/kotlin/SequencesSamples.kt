import java.util.concurrent.TimeUnit
import kotlin.system.measureNanoTime

fun main() {
    measure { list() } // 60ms
    measure { sequence() } // 6ms
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

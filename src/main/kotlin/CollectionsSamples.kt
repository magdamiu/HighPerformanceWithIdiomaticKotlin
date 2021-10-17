class Language(val name: String)

val kotlin = Language("kotlin")
val java = Language("java")
val scala = Language("scala")
val languages = listOf(kotlin, java, scala)

fun main() {
    val benchmarks = Benchmarks()
    benchmarks.forEachIterator()
    benchmarks.forEachWhile()
}

open class Benchmarks {
    inline fun <reified T> List<T>.customForEach(crossinline invoke: (T) -> Unit): Unit {
        val size = size
        var i = 0
        while (i < size) {
            invoke(get(i))
            i++
        }
    }

    fun forEachIterator() {
        languages.forEach {
            println(it.name)
        }
    }

    fun forEachWhile() {
        languages.customForEach {
            println(it.name)
        }
    }
}
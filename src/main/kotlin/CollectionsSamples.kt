class Language(val name: String)

val kotlin = Language("kotlin")
val java = Language("java")
val scala = Language("scala")
val languages = listOf(kotlin, java, scala)

// Works
fun List<Language>.getNames1(): List<String> = this
    .map { it.name }
    .filter { it != null }
    .map { it!! }

// Better
fun List<Language>.getNames2(): List<String> = this
    .map { it.name }
    .filterNotNull()

// Best
fun List<Language>.getNames3(): List<String> = this
    .mapNotNull { it.name }


fun main() {
    val benchmarks = Benchmarks()
    benchmarks.forEachIterator()
    benchmarks.forEachWhile()
}

open class Benchmarks {
    inline fun <reified T> List<T>.customForEach(
        crossinline invoke: (T) -> Unit
    ): Unit {
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
package inline

fun main() {
    val sequence = listOf(1, 2, 3).asSequence()
    sequence.map { it % 2 == 0 }

    val list = listOf(1, 2, 3)
    list.filter { it % 2 == 0 }.map { it / 2 }

}

class Book(val title: String, val author: String) {
    // impure function
    fun getBookDetails() = "$title - $author"

    // pure function
    fun getBookDetails(title: String, author: String) =
        "$title - $author"
}

fun main(args: Array<String>) {

    // declarative vs functional
    val numbers = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println("declarative approach")
    println(declarativeApproach(numbers))
    println("functional approach")
    println(functionalApproach(numbers))

    val book1 = Book("Start with why", "Simon Sinek", 2009, 23.0)
    val book2 = Book("Drive", "Daniel Pink", 2009, 21.4)
    val book3 = Book("Dare to lead", "Brene Brown", 2018, 18.5)
    val book4 = Book("Good to Great", "Jim Collins", 2001, 19.75)
    val books = listOf(book1, book2, book3, book4)
    val filteredBooks = books
        .filter(::titleStartsWithS)
        .filter(::authorStartsWithB)
        .filter(::lengthOfTitleGraterThan5)
    println(filteredBooks)

    books.filter(fun(book: Book) = titleStartsWithS(book)
            && lengthOfTitleGraterThan5(book)
            && authorStartsWithB(book))

    books.filter(
        ::titleStartsWithS
                and ::authorStartsWithB
                and ::lengthOfTitleGraterThan5
    )

    println(books.minByOrNull { it.year })

    var priceBooks = 0.0
    val prefixPriceDetails = "The current sum is "
    books.forEach {
        priceBooks += it.price
        println("$prefixPriceDetails $priceBooks")
    }

    // function types
    val sum: (Int, Int) -> (Int) = { a, b -> a + b }
    val printPIValue: () -> Unit = { println(Math.PI) }

    // nullable return type
    var canReturnNull: (Int, Int) -> Int? = { _: Int, _: Int -> null }

    //nullable variable of a function type
    var funOrNull: ((Int, Int) -> Int)? = null
}

fun declarativeApproach(numbers: List<Int>): List<Int> {
    val evenNumbers = ArrayList<Int>()
    for (index in 0..numbers.lastIndex) {
        val currentNumber = numbers[index]
        if (currentNumber % 2 == 0) {
            evenNumbers.add(currentNumber)
        }
    }
    return evenNumbers
}

fun functionalApproach(numbers: List<Int>): List<Int> {
    return numbers.filter { it % 2 == 0 }
}

class Book(val title: String, val author: String, val year: Int = 1900, val price: Double) {
    // impure function
    fun getBookDetails() = "$title - $author"

    // pure function
    fun getBookDetails(title: String, author: String) = "$title - $author"
}

fun titleStartsWithS(book: Book): Boolean = book.title.startsWith("S")

fun lengthOfTitleGraterThan5(book: Book): Boolean = book.title.length > 5

fun authorStartsWithB(book: Book): Boolean = book.author.startsWith("B")

fun allFilters(book: Book): Boolean = titleStartsWithS(book)
        && lengthOfTitleGraterThan5(book)
        && authorStartsWithB(book)

inline infix fun <P> ((P) -> Boolean).and(
    crossinline predicate: (P) -> Boolean
): (P) -> Boolean {
    return { p: P -> this(p) && predicate(p) }
}



fun main() {
    var counter = 0
    repeat(3000) {
        counter++
    }
    repeat3000 {
        counter++
    }
    println(counter)
}
fun repeat3000(action: (Int) -> Unit) {
    for (index in 0..2999) {
        action(index)
    }
}



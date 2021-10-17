package inline

inline fun <T, R : Comparable<R>> Iterable<T>.sortedBy(
    crossinline selector: (T) -> R?
): List<T> {
    return sortedWith(compareBy(selector))
}

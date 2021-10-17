package inline

// For JVM backends
@JvmInline
value class Password(private val s: String)

fun main() {
    val securePassword = Password("Don't try this in production")
    println(securePassword)
}
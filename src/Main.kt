
import kotlin.math.max

fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
}

fun main() {
    val (y, w) = readLine()!!.split(" ").map { it.toInt() }

    val favorable = 7 - max(y, w)
    val total = 6

    val g = gcd(favorable, total)

    println("${favorable / g}/${total / g}")
}
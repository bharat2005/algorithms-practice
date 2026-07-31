
fun main() {
    val (n, k) = readln().split(" ").map { it.toLong() }

    var ans = k

    repeat((n - 1).toInt()) {
        ans *= (k - 1)
    }

    println(ans)
}




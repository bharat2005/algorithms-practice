fun main() {
    val n = readLine()!!.toInt()
    val k = readLine()!!.toInt()
    val x = readLine()!!.toInt()
    val y = readLine()!!.toInt()

    val total = minOf(n, k) * x + maxOf(0, n - k) * y

    println(total)
}
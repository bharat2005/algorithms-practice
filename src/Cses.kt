fun main() {
    val n = readLine()!!.toInt()
    val k = 31 - Integer.numberOfLeadingZeros(n)

    println(k)
}
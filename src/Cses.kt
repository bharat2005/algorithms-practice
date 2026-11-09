fun main() {
    val n = readLine()!!.toInt()
    val k = readLine()!!.toInt()

    println(if(n and (1 shl k) == 0) 0 else 1)
}
fun main() {
    var n = readLine()!!.toInt()
    val k = readLine()!!.toInt()

    n = n or (1 shl k)
    n = n and (1 shl k).inv()
    n = n xor (1 shl k)

    println(n.toString(2))
}
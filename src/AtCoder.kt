fun main() {
    val (n,a,b) = readLine()!!.split(" ").map { it.toInt() }
    val s = readLine()!!
    println(s.substring(a,b-1))
}
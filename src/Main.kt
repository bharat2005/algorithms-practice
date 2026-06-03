fun main() {
    val (x, y) = readLine()!!.split(" ").map { it.toInt() }

    val fav = 6 - maxOf(x, y) + 1

    var a = fav
    var b = 6

    while(b != 0){
        val temp = a
        a = b
        b = temp % b
    }

    println("${fav/a}/${6/a}")

}


fun main() {
    val t = readLine()!!.toInt()

    repeat(t){
        var (x, y, k) = readLine()!!.split(" ").map { it.toInt() }
        var res = 0
        repeat(k){
            res += x % y
            x++
            y++
        }
        println(res)
    }


}


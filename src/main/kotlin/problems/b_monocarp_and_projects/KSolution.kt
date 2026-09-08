package problems.b_monocarp_and_projects

import java.util.Scanner


fun main() {
    val t = readLine()!!.toInt()

    repeat(t){
        var (x, y, k) = readLine()!!.split(" ").map { it.toLong() }
        var res = 0L
        repeat(k){
            res += x % y
            x++
            y++
        }
        println(res)
    }


}

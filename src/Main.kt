
import kotlin.math.abs

fun main() {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }
    if (n <= 2) {
        println(0)
        return
    }
    var min = Int.MAX_VALUE

    fun dfs(index: Int, prev: Int, ops: Int, diff: Int) {
        if (index == n) {
            min = minOf(min, ops)
            return
        }
        val curr = arr[index]
        val d1 = curr - prev
        val d2 = curr + 1 - prev
        val d3 = curr - 1 - prev

        if (diff == d1) {
            dfs(index + 1, curr, ops, diff)
        } else if (diff == d2) {
            dfs(index + 1, curr + 1, ops + 1, diff)
        } else if (diff == d3) {
            dfs(index + 1, curr - 1, ops + 1, diff)
        }
    }



    for (c1 in -1..1) {
        for (c2 in -1..1) {
            val first = arr[0] + c1
            val second = arr[1] + c2
            val diff = second - first

            var ops = 0
            if (c1 != 0) ops++
            if (c2 != 0) ops++

            dfs(2, second, ops, diff)
        }
    }

    println(if (min == Int.MAX_VALUE) -1 else min)


}
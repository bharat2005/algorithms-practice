import java.util.Scanner

fun main() {
    val t = readLine()!!.toInt()
    
    repeat(t) {
        val n = readLine()!!.toInt()
        val arr = readLine()!!.split(" ").map { it.toInt() }
    
    
        val sumArray = BooleanArray(n + 1)
    
        for (i in 0 until n - 1) {
            var currSum = arr[i]
            for (j in i + 1 until n) {
                currSum += arr[j]
                if (currSum > n) break
                sumArray[currSum] = true
            }
        }
        var count = 0
        for (x in arr) {
            if (sumArray[x]) {
                count++
            }
        }
    
    
        println(count)
    }
}

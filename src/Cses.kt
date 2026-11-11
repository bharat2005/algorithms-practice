fun main() {
    var (a, b) = readLine()!!.split(" ").map { it.toInt() }

    val dp = listOf(1,2,4)

    val aset = intArrayOf(5)
    var i = 0
    while (a > 0) {
        while(dp[i] <= a) i++
        a -= dp[i++]
        aset[i]++
    }
    val bset = intArrayOf(5)
    i = 0
    while (b > 0) {
        while(dp[i] <= b) i++
        b -= dp[i++]
        bset[i]++
    }

    var sum = 0
    for(i in 1..4){
        val bool = maxOf(aset[i],bset[i]) == 1
        if(bool) sum += i
    }

    println(sum)


}
fun assignUmbrella(rain: IntArray): Array<String> {
    val n = rain.size
    val a = Array(n){ "" }
    var aliceHistory = 0
    var bobHistory = 0

    for(i in 0 until n){
        val alice = rain[i] == 1 && rain[i + 1] == 1
        val bob = rain[i] == 1


        if(alice && aliceHistory >= bobHistory){
            aliceHistory++
            a[i] = "Alice"
        } else if (bob) {
            bobHistory++
            a[i] = "Bob"
        } else {
            a[i] = "None"
        }

    }


    return a

}

fun minRange(a: Int, b: Int, c: Int): Int {
    val sorted = intArrayOf(a, b, c).sorted()

    return (sorted[0] + sorted[1]) - minOf(a, b)

}
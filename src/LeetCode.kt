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
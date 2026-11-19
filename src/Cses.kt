fun main() {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map { it.toLong() }

    var minXor = 0L
    for(mask in 0 until (1 shl (n-2))){
        var accumulatedXOR = 0L
        var currentOR = 0L
        for(i in 0 until n-1){
            if(mask and (1 shl i) != 0){
                //partition
                accumulatedXOR = accumulatedXOR xor currentOR
                currentOR = 0
            } else {
                //accumulate OR
                currentOR = currentOR or a[i]
            }
        }
        minXor = minOf(minXor, accumulatedXOR)

    }
    print(minXor)
}
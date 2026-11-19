fun main() {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map { it.toLong() }

    var minXor = Long.MAX_VALUE
    for(mask in 0 until (1 shl (n-1)) ){
        var accumulatedXOR = 0L
        var currentOR = a[0]
        for(i in 0 until n-1){
            if(mask and (1 shl i) != 0){
                //partition
                accumulatedXOR = accumulatedXOR xor currentOR
                currentOR =  a[i+1]
            } else {
                //accumulate OR
                currentOR = currentOR or a[i+1]
            }
        }
        accumulatedXOR = accumulatedXOR xor currentOR
        minXor = minOf(minXor, accumulatedXOR)

    }
    print(minXor)
}
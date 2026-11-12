fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val a = readln().split(" ").map { it.toInt() }
    var ans = 0

    for(s in 0 until (1 shl n)){
        var accumulatedXor = 0

        //iterate though ref arr so to get actual value to accumulate accroding to mem check
        for(i in 0 until a.size){
            if(s and (1 shl i) != 0){
                accumulatedXor += a[i]
            }
        }

        if(accumulatedXor == m) ans++
    }

    println(ans)
}
fun main(){
    val n = readln().toInt()
    val k = readln().toInt()
    val a = readln().split(" ").map {it.toInt()}
    var ans = 0

    for(s in 1 until (1 shl n)){
        var accumulatedAnd = -1

        for(i in 0 until a.size){
            if(s and (1 shl i ) != 0) accumulatedAnd = (accumulatedAnd and a[i])
        }

        if(accumulatedAnd == k) ans++
    }
    println(ans)

}
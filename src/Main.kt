
fun main(){
    val (n,w) = readLine()!!.split(" ").map { it.toInt() }
    val arr = readLine()!!.split(" ").map { it.toInt() }

    var sum = 0
    var minS = 0
    var maxS = w
    for(x in arr) {
        sum+=x
        minS = minOf(minS,sum)
        maxS = maxOf(maxS,sum)
    }
    val ans = w - maxS + minS + 1

    if(ans < 0) println(0) else println(ans)
}

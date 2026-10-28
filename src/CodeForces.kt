fun main() {
    //extract
    val (n, wx, hx) = readLine()!!.split(" ").map { it.toInt() }
    val arr = mutableListOf<List<Int>>()
    for (i in 0 until n){
        val (w, h) = readLine()!!.split(" ").map { it.toInt() }
        if(w > wx && h > hx){
            arr.add(listOf(w, h, i))
        }
    }
    //no possible result
    if(arr.isEmpty()) {
        println(0)
        return
    }

    //sort asce as per width for non full iterations
    arr.sortBy { it[0] }

    //build priority dp
    val m = arr.size
    val dp = IntArray(m){ 1 }
    val prnt = IntArray(m) { -1 }
    var best = 0
    for(i in 0 until m){
        for(j in 0 until i){
            if(arr[j][0] < arr[i][0] && arr[j][1] < arr[i][1]){
                if(dp[j] + 1 > dp[i]){
                      dp[i] = dp[j] + 1
                      prnt[i] = j
                }
            }
        }
        if(dp[best] < dp[i]) best = i
    }


    //constrct back the chain
    val set = mutableSetOf<Int>()
    var curr = best
    while(curr != -1){
        set.add(arr[curr][2] + 1)
        curr = prnt[curr]
    }

    println(set.size)
    println(set.reversed().joinToString(" "))
}

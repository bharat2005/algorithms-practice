fun main() {

    val (n, ws, hs) = readLine()!!.split(" ").map { it.toInt() }
    val arr = mutableListOf<List<Int>>()
    for(i in 0 until n){
        val (w, h) = readLine()!!.split(" ").map { it.toInt() }
        if(w > ws && h > hs){
            arr.add(listOf(w, h, i))
        }
    }

    //no res
    if(arr.isEmpty()){
        println(0)
        return
    }

    //make close first chain
    val que = ArrayDeque<Int>()
    var currH = hs
    var currW = ws
    //repeat to arr.size to build arr.sized chain
    repeat(arr.size){
        var currMinDiff = Int.MAX_VALUE
        var currMinIdxOrg = -1
        var currMinIdxStl = -1

        //loop through to get next closest envelop
        for(i in 0 until arr.size){
            val w = arr[i][0]
            val h = arr[i][1]
            val idx = arr[i][2]


            val minDiff = w - currH + h - currW
            if(w > currW && h > currH && minDiff < currMinDiff){
                currMinDiff = minDiff
                currMinIdxOrg = i
                currMinIdxStl = idx
            }
        }

        //append closest envlope index
        if (currMinIdxOrg != -1){
            currW = arr[currMinIdxOrg][0]
            currH = arr[currMinIdxOrg][1]
            que.addLast(currMinIdxStl)
        }
    }

    println(que.size)
    que.forEach { print("${it + 1} ") }

}
































fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val arr = readLine()!!.split(" ").map { it.toInt() }

    val res = mutableListOf<List<Int>>()

    var currMin = Int.MAX_VALUE
    var currMinIdx = -1

    var currMax = Int.MIN_VALUE
    var currMaxIdx = -1

    var bestDiff = 0

    for( i in 0 until n){
        if(Math.abs(currMin - currMax) > k){
            bestDiff = Math.abs(currMax - currMin)

            res.add(listOf(currMinIdx, currMaxIdx))
            currMin = Int.MAX_VALUE
            currMax = Int.MIN_VALUE
            currMaxIdx = -1
            currMinIdx = -1
            continue
        }

        if(currMin > arr[i]){
            currMin = arr[i]
            currMinIdx = i
        }

        if(currMax < arr[i]){
            currMax = arr[i]
            currMaxIdx = i
        }


    }


    println("${res.size} ${bestDiff}")
    res.forEach { println(it.joinToString(" ")) }
}
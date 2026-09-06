
fun main() {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }
    val lenMap = mutableMapOf<Int, Int>() //value to count
    val indexMap = mutableMapOf<Int, Int>() //value to index
    val lineageMap = mutableMapOf<Int, Int>() //index to index

    var maxLen = Int.MIN_VALUE
    var bestEnd = -1
    for(i in arr.indices){
        val x = arr[i]
        indexMap[x] = i

        if(lenMap.contains(x - 1)){
            //maintain len
            lenMap[x] = lenMap[x-1]!! + 1

            //maintain idx lineage
            val prevIdx = indexMap[x-1]!!
            lineageMap[i] = prevIdx
        } else {
            //default start
            lenMap[x] = 1
        }

        //track maxLen last idx
        if(maxLen < lenMap[x]!!){
            maxLen = lenMap[x]!!
            bestEnd = i
        }

    }

    //build ans
    val sb = StringBuilder("")
    var curr = bestEnd
    while(lineageMap.contains(curr)){
        sb.append("${curr} ")
        curr = lineageMap[curr]!!
    }
    sb.append(curr)

    println(sb.toString().reversed() )

}

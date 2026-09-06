
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
            lenMap[x] = lenMap[x-1]!! + 1
            if(maxLen < lenMap[x-1]!! + 1) bestEnd = i

            val prevIdx = indexMap[x-1]!!
            lineageMap[i] = prevIdx
        } else {
            lenMap[x] = 1
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

    println(sb.toString().reversed())

}

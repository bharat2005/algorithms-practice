import kotlin.math.abs

fun main(){
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }
    val visited = BooleanArray(arr.size){false}

    var currPos = 0
    var count = 0

    repeat(n){
        var minDiff = Int.MAX_VALUE
        var minIndex = -1
        for(i in 0 until n ){
            if(!visited[i]){
                val curDiff = abs(currPos - arr[i])
                if(minDiff > curDiff ){
                    minIndex = i
                    minDiff = curDiff
                }
            }
        }
        currPos = arr[minIndex]
        count += abs(currPos)
        visited[minIndex] = true
    }

    print(count)

}
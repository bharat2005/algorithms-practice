import kotlin.math.abs

fun main(){
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }
    val visited = BooleanArray(arr.size){false}

    var curr = 0

    repeat(n){
        var min = Int.MAX_VALUE
        for(i in 0 until n ){
            if(visited[i]){
                min = minOf(min, abs(curr - arr[i]))
            }
        }
        curr += min
    }

    print(curr)

}
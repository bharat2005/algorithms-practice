import kotlin.math.abs

fun main() {
    val n = readLine()!!.toInt()
    val ls = readLine()!!.split(" ").map { it.toLong() }
    var total = ls.sum()
    var min = Long.MAX_VALUE // exceeds int range

    fun dfs(currIdx : Int, currSum : Long) : Unit {
        if(currIdx == n){
            //update final anser min
            min = minOf(min, abs(total - currSum - currSum))
            return
        }

        dfs(currIdx + 1,currSum + ls[currIdx] )
        dfs(currIdx + 1, currSum )
    }

    dfs(0, 0)

    println(min)
}






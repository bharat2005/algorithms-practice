import kotlin.math.abs

fun main() {
    val n = readLine()!!.toInt()
    val ls = readLine()!!.split(" ").map { it.toInt() }
    val total = ls.sum()
    var min = Int.MAX_VALUE

    fun dfs(currIdx : Int, currSum : Int) : Unit {
        if(currIdx == n){
            //update final anser min
            min = minOf(min, abs(total - currSum - currSum))
            return
        }

        dfs(currIdx + 1,currSum + ls[currIdx] )
        dfs(currIdx + 1, currSum )
    }

    dfs(0, 0)
}






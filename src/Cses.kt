fun main() {
    val n = 5
    val matrix = Array(n) { IntArray(n) { 0 } }

    fun rec(worker : Int, currCost : Int){
        if(worker == n){
            println("Most Minimal Cost - $currCost")
            return
        }

        var minCost = Int.MAX_VALUE
        for(job in 0 until n){
            minCost = minOf(minCost, matrix[worker][job])
        }
        rec(worker + 1, currCost + minCost)
    }


    rec(0, 0)


}
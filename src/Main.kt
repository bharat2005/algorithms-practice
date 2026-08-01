
fun main() {
    val n = readLine()!!.toInt()
    val grid = Array(n) {
        IntArray(n)
    }

    for(i in 0 until n){
        for(j in 0 until n){
            //build union set
            val set = BooleanArray(2 * n)
                //left
            for(x in 0 until j){
                set[grid[i][x]] = true
            }
                //above
            for(y in 0 until i){
                set[grid[y][j]] = true
            }

            //check mex
            var mex = 0
            while(set[mex]) mex++
            grid[i][j] = mex
        }
        grid[i].forEach { print("$it ") }
        println()
    }
}




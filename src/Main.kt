fun main(){
    val (m, n) = readLine()!!.split(" ").map { it.toInt() }
    val grid = Array(m) {
        readLine()!!.toCharArray()
    }
    val charArr = charArrayOf('A', 'B', 'C', 'D')

    for(i in 0 until m){
        for(j in 0 until n){
            val curr = grid[i][j]
            val top = if(i - 1 in 0..<m) grid[i - 1][j] else curr
            val left = if(j-1 in 0..<n) grid[i][j-1] else curr

            var x = 0
            while(charArr[x] != curr && charArr[x] != top && charArr[x] != left) x++

            grid[i][j] = charArr[x]
        }
        println(grid[i].joinToString(" "))
    }
}



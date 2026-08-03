fun main(){
    val (m, n) = readLine()!!.split(" ").map { it.toInt() }
    val grid = Array(m) { readLine()!!.toCharArray() }

    for(i in 0 until m){
        for(j in 0 until n){
            val current = grid[i][j]
            if( i + j % 2 == 0){
                grid[i][j] = if(current == 'A') 'B' else 'A'
            } else {
                grid[i][j] = if(current == 'C') 'D' else 'C'
            }

        }
        println(grid[i].joinToString(" "))
    }
}



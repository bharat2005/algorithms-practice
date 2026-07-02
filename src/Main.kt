val dr = intArrayOf(0,1,0,-1)
val dc = intArrayOf(1,0,-1,0)


fun main() {
    fun findSafeWalk(grid: List<List<Int>>, health: Int): Boolean {
        val m = grid.size
        val n = grid[0].size
        val best = Array(m) { IntArray(n) { Int.MAX_VALUE } }
        val dq = ArrayDeque<IntArray>()

        best[0][0] = grid[0][0]
        dq.addFirst(intArrayOf(grid[0][0], 0, 0))

        while (dq.isNotEmpty()) {
            val (sum, r, c) = dq.removeFirst()

            //check ends
            if(r == m-1 && c == n-1){
                return if ( health - sum > 1) true else false
            }

            //check adj
            for (i in 0 until 4) {
                val nr = r + dr[i]
                val nc = c + dc[i]

                //check bounds
                if(nr !in 0..m-1 && nc !in 0..n-1)  continue

                //update best
                val nsum = best[r][c] + grid[nr][nc]
                if(nsum < best[nr][nc]) {
                    best[nr][nc] = nsum
                    //manage dq
                    if (grid[nr][nc] == 0) {
                        dq.addFirst(intArrayOf(nsum, nr, nc))
                    } else {
                        dq.addLast(intArrayOf(nsum, nr, nc))
                    }
                }


            }
        }


        //edge case of m=1;n=1
        return if(health - best[m-1][n-1] > 1) true else false

    }

}







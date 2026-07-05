
fun main() {

    val dr = intArrayOf(0, 1, 1)
    val dc = intArrayOf(1, 0, 1)

    fun pathsWithMaxScore(board: List<String>): IntArray {
        val n = board.size
        val m = board[0].length
        val scoreboard = Array(n) { IntArray(m){ -1 } }
        val pathsboard = Array(n) { IntArray(n) }
        scoreboard[n-1][m-1] = 0
        pathsboard[n-1][m-1] = 1

        for( r in n-1 downTo 0){
            for(c in m-1 downTo 0) {
                if (board[r][c] == 'X' || board[r][c] == 'S') continue

                var bestScore = -1
                var bestPath = 0

                for (i in 0..2) {
                    val nr = r + dr[i]
                    val nc = c + dc[i]
                    if (nr >= n || nc >= m) continue

                    val thisScore = scoreboard[nr][nc]
                    if (thisScore == -1) continue

                    if (thisScore > bestScore) {
                        bestScore = thisScore
                        bestPath = pathsboard[nr][nc]
                    } else if (thisScore == bestScore) {
                        bestPath += pathsboard[nr][nc]
                    }
                }

                if(bestScore == -1) continue

                val value = when(board[r][c]){
                    'E' -> 0
                    else -> board[r][c] - '0'
                }
                scoreboard[r][c] = value + bestScore
                pathsboard[r][c] = bestPath

            }
        }



        return if(pathsboard[0][0] == 0) intArrayOf(0,0) else intArrayOf(scoreboard[0][0],pathsboard[0][0])

    }

}







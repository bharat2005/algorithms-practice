





fun main() {
    val paths = readLine()!!
    val visited = Array(7) { BooleanArray(7)}
    var res = 0
    val map = mapOf<Char, Pair<Int, Int>>(
        'U' to Pair(-1,0),
        'D' to Pair(1,0),
        'L' to Pair(0, -1),
        'R' to Pair(0, 1)
    )

    fun isBlocked(row : Int, column : Int) : Boolean {
        //out of bound
        if(row !in 0..6 || column !in 0..6) return true
        //already visited
        if(visited[row][column]) return true

        //else
        return false

    }
    fun dfs(r : Int, c : Int, step : Int){

        //base case
        if(r == 6 && c == 0 && step == 48){
            res++
            return
        }




        //pruning cases (2)
            //i) ending in wrong cell
        if(step == 48) return

            //ii)future failer cases
                //-horizontal closure
        if(    isBlocked(r-1, c)
            && isBlocked(r+1, c)
            && !isBlocked(r,c-1)
            && !isBlocked(r,c+1)
            )return
                //-vertical closure
        if(    isBlocked(r, c-1)
            && isBlocked(r, c+1)
            && !isBlocked(r+1,c)
            && !isBlocked(r-1,c)
            )return




        //move ahead
        visited[r][c] = true
        val ch = paths[step]
        if(ch == '?'){
            //move all possible dir
            for(i in listOf('U', 'D', 'L', 'R')){
                val nr = r + map[i]!!.first
                val nc = c + map[i]!!.second
                if(!isBlocked(nr,nc )){
                    dfs(nr,nc, step+1)
                }
            }
        } else {
            //move to path dir
            val nr = r + map[ch]!!.first
            val nc = c + map[ch]!!.second
            if(!isBlocked(nr,nc )){
                dfs(nr,nc, step+1)
            }

        }
        visited[r][c] = false

    }

    dfs(0,0,0)

    println(res)

}



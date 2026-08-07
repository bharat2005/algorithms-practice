fun main() {
    val paths = readLine()!!
    val visited = Array(7) { BooleanArray(7)}
    var res = 0

    val dir = listOf('U','D','L','R')
    val dr = listOf(-1,1,0,0)
    val dc = listOf(0,0,-1,1)


    fun isBlocked(row : Int, column : Int) : Boolean {
        //out of bound
        if(row !in 0..6 || column !in 0..6) return true
        //already visited
        if(visited[row][column]) return true

        //else
        return false

    }
    fun dfs(r : Int, c : Int, step : Int){

        //base cases
        //reached desired end
        if(r == 6 && c == 0 && step == 48){
            res++
            return
        }
        //reached at wrong end
        if(step == 48) return




        //pruning cases
            //i) reaching too early
        if(r == 6 && c == 0) return

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
        for(i in 0..3){
            if(ch != '?' && dir[i] != ch) continue
            val nr = r + dr[i]
            val nc = c + dc[i]
            if(!isBlocked(nr, nc)){
                dfs(nr,nc,step + 1)
            }
        }

        visited[r][c] = false

    }

    dfs(0,0,0)

    println(res)

}



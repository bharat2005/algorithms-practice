


fun main() {
    val paths = readLine()!!
    val visited = Array(7) { BooleanArray(7)}
    var res = 0

    val dir = listOf('U','D','L','R')
    val dr = listOf(-1,1,0,0)
    val dc = listOf(0,0,-1,1)


    fun isBlocked(row : Int, column : Int) : Boolean {
        //out of bound or alredy visited
        return row !in 0..6 || column !in 0..6 || visited[row][column]
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



        visited[r][c] = true

        //pruning cases
            //i) reaching too early
        if(r == 6 && c == 0){
            visited[r][c] = false
            return
        }

            //ii)future failer cases
                //-horizontal closure
        if(    isBlocked(r-1, c)
            && isBlocked(r+1, c)
            && !isBlocked(r,c-1)
            && !isBlocked(r,c+1)
            ) {
            visited[r][c] = false
            return
        }
                //-vertical closure
        if(    isBlocked(r, c-1)
            && isBlocked(r, c+1)
            && !isBlocked(r+1,c)
            && !isBlocked(r-1,c)
            ){
            visited[r][c] = false
            return
        }




        //move ahead
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



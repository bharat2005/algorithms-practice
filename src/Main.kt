fun main() {
    val paths = readLine()!!

    val visited = BooleanArray(81)
    //add padding
    for(i in 0..8){
        visited[i] = true
        visited[72 + i] = true
        visited[9 * i] = true
        visited[9 * i + 8] = true
    }

    var res = 0

    val dir = listOf('U','D','L','R')
    val dr = listOf(-1,1,0,0)
    val dc = listOf(0,0,-1,1)

    fun dfs(r : Int, c : Int, step : Int){
        val idx = r * 9 + c

        //base cases
        //reached desired end
        if(idx == 64 && step == 48){
            res++
            return
        }
        //reached at wrong end
        if(step == 48) return





        //pruning cases
            //i) reaching too early
        if(idx == 64) return


            //ii)future failer cases
        val up = visited[idx - 9]
        val down = visited[idx + 9]
        val right = visited[idx + 1]
        val left = visited[idx - 1]
                //-horizontal closure
        if(    up
            && down
            && !right
            && !left
            ) return
                //-vertical closure
        if(    right
            && left
            && !up
            && !down
            ) return





        //move ahead
        visited[idx] = true
        val ch = paths[step]
        for(i in 0..3){
            if(ch != '?' && dir[i] != ch) continue
            val nr = r + dr[i]
            val nc = c + dc[i]
            if(!visited[nr * 9 + nc]){
                dfs(nr,nc,step + 1)
            }
        }
        visited[idx] = false

    }

    dfs(1,1,0)

    println(res)

}



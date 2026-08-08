fun main() {
    val paths = readLine()!!.map {
        when(it) {
            'U' -> 0
            'D' -> 1
            'L' -> 2
            'R' -> 3
            else -> 4
        }
    }.toIntArray()


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
        if(ch == 0){
            //up
            if(!visited[idx - 9]) dfs(r - 1, c, step+1)
        } else if(ch == 1){
            //Down
            if(!visited[idx + 9]) dfs(r + 1, c, step+1)
        }else if(ch == 2){
            //left
            if(!visited[idx - 1]) dfs(r, c-1, step+1)
        } else if(ch == 3){
            //right
            if(!visited[idx + 1]) dfs(r, c+1, step+1)
        } else{
            //all
            if(!visited[idx - 9]) dfs(r - 1, c, step+1)
            if(!visited[idx + 9]) dfs(r + 1, c, step+1)
            if(!visited[idx - 1]) dfs(r, c-1, step+1)
            if(!visited[idx + 1]) dfs(r, c+1, step+1)
        }

        visited[idx] = false

    }

    dfs(1,1,0)

    println(res)

}



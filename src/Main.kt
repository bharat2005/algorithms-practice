



fun main() {
    val path = readLine()!!
    val n = path.length
    var ans = 0
    val grid = Array(7) { BooleanArray(7)}

    fun isblock(r : Int,c : Int) : Boolean {
        //out of grid
        if(r !in 0 until 7 || c !in 0 until 7) return true

        //alredy visited
        return grid[r][c]

    }
    fun dfs(r : Int, c : Int, step : Int){

        //base case
            //reached
        if(r == 0 && c == 6 && step == n){
            ans++
            return
        }
            //incorrect path
        if(step == n) return

        //pruning
            //horizontal split
        if(isblock(r-1, c) && isblock(r+1, c) && !isblock(r,c-1) && !isblock(r,c+1))return
            //vertical split
        if(!isblock(r-1, c) && !isblock(r+1, c) && isblock(r,c-1) && isblock(r,c+1))return

        //mark visited
        grid[r][c] = true
        //try further path
        if(path[step] != '?'){
            //try perticular dir
            when(path[step]){
                'U' -> {
                    if(!isblock(r-1,c)){
                        dfs(r-1,c, step+1)
                    }
                }
                'D' -> {
                    if(!isblock(r+1,c)){
                        dfs(r+1,c, step+1)
                    }
                }
                'R' -> {
                    if(!isblock(r,c+1)){
                        dfs(r,c+1, step+1)
                    }
                }
                'L' -> {
                    if(!isblock(r,c-1)){
                        dfs(r,c-1, step+1)
                    }
                }
            }
        } else
        {
            //try all dir
            if(!isblock(r-1,c)){
                dfs(r-1,c, step+1)
            }
            if(!isblock(r+1,c)){
                dfs(r+1,c, step+1)
            }
            if(!isblock(r,c+1)){
                dfs(r,c+1, step+1)
            }
            if(!isblock(r,c-1)){
                dfs(r,c-1, step+1)
            }
        }
        //unmark visited
        grid[r][c] = false


    }

    dfs(0,0, 0)

    println(ans)

}



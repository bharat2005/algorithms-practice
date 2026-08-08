
import java.io.InputStream

fun main() {
    val paths = readLine()!!

    val visited = Array(9) { BooleanArray(9)}
    //add padding
    for(i in 0 until 8){
        visited[0][i] = true
        visited[8][i] = true
        visited[i][0] = true
        visited[8][i] = true
    }

    var res = 0

    val dir = listOf('U','D','L','R')
    val dr = listOf(-1,1,0,0)
    val dc = listOf(0,0,-1,1)

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
        if(    visited[r-1][c]
            && visited[r+1][c]
            && !visited[r][c-1]
            && !visited[r][c+1]
            ) return
                //-vertical closure
        if(    visited[r][c-1]
            && visited[r][c+1]
            && !visited[r+1][c]
            && !visited[r-1][c]
            ) return





        //move ahead
        visited[r][c] = true
        val ch = paths[step]
        for(i in 0..3){
            if(ch != '?' && dir[i] != ch) continue
            val nr = r + dr[i]
            val nc = c + dc[i]
            if(!visited[nr][nc]){
                dfs(nr,nc,step + 1)
            }
        }
        visited[r][c] = false

    }

    dfs(0,0,0)

    println(res)

}



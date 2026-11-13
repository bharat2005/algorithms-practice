fun main(){
    val (n, m) = readln().split(" ").map { it.toInt() }
    val adj = Array(n+1){
        mutableListOf<List<Int>>()
    }
    repeat(m){
        val (u, v, w) = readln().split(" ").map { it.toInt() }
        adj[u].add(listOf(v,w))
        adj[v].add(listOf(u,w))
    }


    val visited = BooleanArray(n+1){false}
    var minXor = Int.MAX_VALUE


    fun dfs(u : Int, accumulatedXor : Int){
        //base case
        if(u == n){
            minXor = minOf(accumulatedXor,minXor)
            return
        }

        visited[u] = true
        //recurse
        for((v,w) in adj[u]){
            if(visited[v]) continue
            visited[v] = true
            dfs(v, accumulatedXor xor w)
            visited[v] = false
        }
        visited[u] = false
    }
    dfs(1,0)
    println(minXor)
}
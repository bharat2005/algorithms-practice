fun main(){
    val (n, m) = readln().split(" ").map { it.toInt() }
    val adj = Array(n+1){
        mutableListOf<List<Long>>()
    }
    repeat(m){
        val (u, v, w) = readln().split(" ").map { it.toLong() }
        adj[u.toInt()].add(listOf(v,w))
        adj[v.toInt()].add(listOf(u,w))
    }


    val visited = BooleanArray(n+1){false}
    var minXor = Long.MAX_VALUE


    fun dfs(u : Int, accumulatedXor : Long){
        //base case
        if(u == n){
            minXor = minOf(accumulatedXor,minXor)
            return
        }

        //recurse
        for((v,w) in adj[u]){
            if(visited[v.toInt()]) continue
            visited[v.toInt()] = true
            dfs(v.toInt(), accumulatedXor xor w.toLong())
            visited[v.toInt()] = false
        }
    }
    dfs(1,0L)
    println(minXor)
}
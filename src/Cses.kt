fun main(){
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val adj = Array(n+1){
        mutableListOf<Pair<Int,Int>>()
    }
    repeat(m){
        val (v, u, w) = readLine()!!.split(" ").map { it.toInt() }
        adj[v].add(Pair(u,w))
        adj[u].add(Pair(v,w))
    }

    var minXor = 0
    var visited = BooleanArray(n+1){false}
    fun dfs(node : Int, accumulatedXor : Int){
        if(node == n){
            minXor = minOf(minXor, accumulatedXor xor n)
            return
        }
        if(visited[node]) return
        for((u,w) in adj[node]){
            dfs(u, accumulatedXor xor w)
        }
        visited[node] = true
    }

    dfs(1, 0)

    println(minXor)

}
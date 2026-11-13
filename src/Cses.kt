fun main(){
    val (n,m) = readln().split(" "). map { it.toInt() }
    val adj = Array(n + 1){
        mutableListOf<List<Long>>()
    }
    repeat(m){
        val (u,v, w) = readln().split(" ").map { it.toLong() }
        adj[u.toInt()].add(listOf(v, w))
        adj[v.toInt()].add(listOf(u,w))
    }
    var minXor = Long.MAX_VALUE



    fun dfs(node : Int, accumulatedXor : Long){
        //base case
        if(node == n){
            minXor = minOf(minXor, accumulatedXor)
        }

        for((v,w) in adj[node]){
            dfs(v.toInt(), accumulatedXor xor w)
        }
    }

    dfs(1, 0)
    println(minXor)
}
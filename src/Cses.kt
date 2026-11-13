fun main() {
    val (n, m, k) = readln().split(" ").map { it.toInt() }
    val aj = Array(n+1){
        mutableListOf<List<Int>>()
    }
    repeat(m){
        val (u,v,w) = readln().split(" ").map { it.toInt() }
        aj[u].add(listOf(v,w))
        aj[v].add(listOf(u, w))
    }

    val xors = mutableListOf<Int>()
    //using visited other wise it will be recureve infinelty
    val visited = BooleanArray(n+1){ false }

    fun dfs(node : Int, accumulatedXor : Int){
        if(node == n){
            xors.add(accumulatedXor)
            return
        }

        visited[node] = true

        for((v, w) in aj[node]){
            if(visited[v]) continue
            dfs(v, accumulatedXor xor w)
        }
        visited[node] = false

    }


    dfs(1, 0)
    println(xors.sorted()[k-1])
}
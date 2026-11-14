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


    val visited = BooleanArray(n+1){ false }
    var ct = 0

    fun dfs(node : Int, accumulatedSum : Int){
        if(node == n){
            if(accumulatedSum % k == 0) ct++
            return
        }

        visited[node] = true

        for((v, w) in aj[node]){
            if(visited[v]) continue
            dfs(v, accumulatedSum + w)
        }
        visited[node] = false

    }


    dfs(1, 0)
    println(ct)
}
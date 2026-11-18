fun main() {
    val (n, m, k) = readLine()!!.split(" ").map { it.toInt() }
    val adj = Array(n + 1){
        mutableListOf<Pair<Int, Int>>()
    }
    repeat(m){
        val (v, u, w) = readLine()!!.split(" ").map { it.toInt() }
        adj[v].add(Pair(u,w))
        adj[u].add(Pair(v,w))
    }

    //dp[mask][endingVertex][reminder]
    val dp = Array(1 shl n){
        Array(n+1){
            IntArray(k){0}
        }
    }
    dp[0][0][0] = 1

    for(mask in 1..(1 shl n)){
        for(v in 0 until n){ //0-index v!! take care ahead!!
            if(v == n)continue
            for((u,w) in adj[v+1]){
                if(mask and (1 shl u) != 0) continue
                val nmask = mask or (1 shl u)
                val nweigth = w % k

                for(r in 0 until k){
                    dp[nmask][u][(r + nweigth) % k] = dp[mask][v][r]
                }
            }
        }
    }

    var ans = 0
    for(mask in dp){
        ans += mask[n][0]
    }
    println(ans)
}
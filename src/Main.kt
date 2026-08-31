

fun main() {
    val (n , m) = readLine()!!.split(" ").map{ it.toInt() }

    //build adj list
    val g = Array(n+1){ mutableListOf<Int>() }
    repeat(m){
        val (n1, n2) = readLine()!!.split(" ").map{ it.toInt() }
        g[n1].add(n2)
        g[n2].add(n1)
    }


    //bfs for all nodes
    var ans = 0
    val visited = BooleanArray(n+1){false}
    for(x in 1..n){
        if(visited[x])continue

        val que = ArrayDeque<Int>()
        que.addLast(x)
        visited[x] = true
        var isCycle = true

        while(que.isNotEmpty()){
            val xx = que.removeFirst()
            val ls = g[xx]

            if(ls.size != 2){
                isCycle = false
            }

            for(i in ls){
                if(visited[i]) continue
                que.addLast(i)
                visited[i] = true
            }
        }

        if(isCycle){
            ans++
        }

    }


    println(ans)
}




























//
//fun main() {
//    fun shortestBeautifulSubstring(s: String, k: Int): String {
//        val n = s.length
//
//        //build prefix sum arr
//        val pfx = IntArray(n)
//        pfx[0] = if(s[0] == '1') 1 else 0
//        for(i in 1 until n){
//            val curr = if(s[i] == '1') 1 else 0
//            pfx[i] = curr + pfx[i-1]
//        }
//
//
//        //try every substring
//        var min = Int.MAX_VALUE
//        var start = -1
//        var end = -1
//        for(i in 0 until n-1){
//            for(j in i+1 until n){
//                val left = if(i == 0) 0 else pfx[i-1]
//                val diff = pfx[j] - left
//                if(diff == k){
//                    if(diff < min){
//                        min = diff
//                        start = i
//                        end = j
//                    }
//                } else if(diff > k){
//                    break
//                }
//            }
//        }
//
//        return if(start != -1 && end != -1) s.substring(start,end) else ""
//    }
//}
//
//
//

















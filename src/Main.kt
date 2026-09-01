
fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }

    val pnt = IntArray(n + 1)
    val dg = IntArray(n + 1)

    fun find(x : Int): Int{
        var rt = x
        while(pnt[rt] != rt){
            rt = pnt[rt]
        }
        var c = x
        while(pnt[c] != rt){
            var temp = pnt[c]
            pnt[c] = rt
            c = temp
        }
        return rt
    }
    fun union(u : Int,v : Int){
        val ru = find(u)
        val rv = find(v)

        if(ru < rv){
            pnt[rv] = ru
        } else if(ru > rv){
            pnt[ru] = rv
        }
    }


    repeat(m){
        val (u, v) = readLine()!!.split(" ").map { it.toInt() }

        dg[u]++
        dg[v]++

        union(u,v)
    }

    val isCycle = BooleanArray(n + 1){true}
    for(i in 1..n){
        if(dg[i] != 2) isCycle[find(i)] = false
    }

    var ans = 0
    for(i in 1..n){
       if(isCycle[find(i)] && pnt[i] == i) ans++
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


















fun main() {
    fun shortestBeautifulSubstring(s: String, k: Int): String {
        val n = s.length

        //build prefix sum arr
        val pfx = IntArray(n)
        pfx[0] = if(s[0] == '1') 1 else 0
        for(i in 1 until n){
            val curr = if(s[i] == '1') 1 else 0
            pfx[i] = curr + pfx[i-1]
        }


        //try every substring
        var min = Int.MAX_VALUE
        var start = -1
        var end = -1
        for(i in 0 until n){
            for(j in i until n){
                val left = if(i == 0) 0 else pfx[i-1]
                val diff = pfx[j] - left
                if(diff == k){
                    val subStrLen = j - i + 1
                    if(subStrLen < min){
                        min = subStrLen
                        start = i
                        end = j
                    }
                } else if(diff > k){
                    break
                }
            }
        }

        return if(start != -1 && end != -1) s.substring(start,end + 1) else ""
    }
}




















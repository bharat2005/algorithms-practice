
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
        for(i in n-1 downTo 0){
            for(j in i downTo 0){
                val right = pfx[i]
                val left = if(j != 0) pfx[j - 1] else 0
                val diff = right - left

                if(diff == k){
                    val subStrLen = i - j + 1
                    if(subStrLen < min){
                        min = subStrLen
                        start = j
                        end = i
                    }
                } else if(diff > k){
                    break
                }
            }
        }

        return if(start != -1 && end != -1) s.substring(start,end + 1) else ""
    }
}




















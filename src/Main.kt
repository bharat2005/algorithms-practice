
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
        var minSubstr = s
        for(i in n-1 downTo 0){
            for(j in i downTo 0){
                val right = pfx[i]
                val left = if(j != 0) pfx[j - 1] else 0
                val diff = right - left

                if(diff == k){
                    var subStr = s.substring(j, i)
                    val subStrLength = subStr.length
                    if(subStr < minSubstr && subStrLength < min){
                        minSubstr = subStr
                        min = subStrLength
                    }

                } else if(diff > k){
                    break
                }
            }
        }

        return if(s != minSubstr) minSubstr else ""
    }
}




















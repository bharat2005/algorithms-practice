import kotlin.math.min

fun main() {
    fun shortestBeautifulSubstring(s: String, k: Int): String {
        val n = s.length

        //build prefix sum arr
        val sfx = IntArray(n)
        sfx[0] = if (s[0] == '1') 1 else 0
        for (i in 1 until n) {
            val curr = if (s[i] == '1') 1 else 0
            sfx[i] = curr + sfx[i - 1]
        }


        //try every substring
        var minLen = Int.MAX_VALUE
        var minSubstr = s
        for (i in 0 until n) {
            for (j in 0 until n) {
                val right = sfx[j]
                val left = if (i != 0) sfx[i - 1] else 0
                val diff = right - left

                if (diff == k) {
                    val subStr = s.substring(i, j + 1)
                    if (subStr.length < minLen) {
                        minLen = subStr.length
                        minSubstr = subStr
                    } else if (subStr.length == minLen && subStr < minSubstr) {
                        minLen = subStr.length
                        minSubstr = subStr
                    }
                } else if (diff > k) {
                    break
                }
            }
        }


        //got better substring than s
        if (s != minSubstr) {
            return minSubstr
        }

        //s might be the only possible substr
        val s1count = s.count { it == '1' }
        if(s1count == k){
            s
        }

        // no possible substr
        return ""
    }
}



















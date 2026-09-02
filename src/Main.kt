import kotlin.math.min

fun main() {
    fun shortestBeautifulSubstring(s: String, k: Int): String {
        val n = s.length

        //build ones indices array
        val ones = mutableListOf<Int>()
        for(i in s.indices){
            if(s[i] == '1') ones.add(i)
        }
        if(ones.size < k) return ""


        //try all k len ones substr
        //var minSubStr = s
        var bestLen = Int.MAX_VALUE
        var bestStart = -1
        for(i in 0..(ones.size - k)){
            val start = ones[i]
            val end = ones[i + k - 1]
            val currLen = end - start + 1

            if(currLen < bestLen){
                bestLen = currLen
                bestStart = start
            } else if(currLen == bestLen && s.substring(start, end + 1) < s.substring(bestStart,  bestStart + bestLen)){
                bestStart = start
            }
        }


        if(bestStart == -1) return ""
        return s.substring(bestStart, bestStart + bestLen)

    }

}



















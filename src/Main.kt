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
        var minSubStr = s
        for(i in 0..(ones.size - k)){
            val start = ones[i]
            val end = ones[i + k - 1]

            val subStr = s.substring(start, end+1)
            val currLen = subStr.length
            val minLen = minSubStr.length
            if(currLen < minLen){
                minSubStr = subStr
            } else if(currLen == minLen && subStr < minSubStr){
                minSubStr = subStr
            }
        }


        return minSubStr

    }

}



















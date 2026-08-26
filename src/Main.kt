
import kotlin.math.abs

fun main() {
    fun shortestBeautifulSubstring(s: String, k: Int): String {
        val n = s.length
        
        //crop accutal substring
        var start = 0
        while(start < n){
            if(s[start] == '1') break
            start++
        }
        var end = n - 1
        while(end > start){
            if(s[end] == '1') break
            end--
        }


        //try every possible substring
        fun countOnes(st : Int, end : Int) : Int{
            var count = 0
            for(i in st..end){
                if(s[i] == '1')count++
            }
            return count
        }
        var min = Int.MAX_VALUE
        var st = -1
        var en = -1
        for(i in start until end - k + 1){
            for(j in i+k-1 until end + 1){
                if(countOnes(i, j) == k){
                    if(j - i + 1 < min){
                        min = j - i + 1
                        st = i
                        en = j
                    }

                }

            }
        }


        return if(st != -1 && en != -1) s.substring(st, en) else ""

    }

}

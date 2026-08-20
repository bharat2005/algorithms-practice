
import kotlin.math.abs

fun main() {
    val s = readLine()!!
    val n = s.length
    var usl = -1
    var usr = -1

    for(left in 0 until n-1){

        for(right in left+1 until n){

            val freq = HashMap<Char,Int>()
            var max = Int.MIN_VALUE
            for(i in left..right){
                val ch = s[i]
                val count = freq.getOrDefault(ch, 0) + 1
                freq[ch] = count
                max = maxOf(max, count)
            }
            if(max > (right - left + 1) / 2){
                //unbalanced substring exists
                usl = left + 1
                usr = right + 1
                break
            }

        }
        if(usl != -1 && usr != -1)break
    }

    println("${usl} ${usr}")


}
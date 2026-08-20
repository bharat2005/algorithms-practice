
import kotlin.math.abs

fun main() {
    val s = readLine()!!
    val n = s.length
    val freq = HashMap<Char, Int>()
    val leftArr = IntArray(26) { -1 }
    val rightArr = IntArray(26) { -1 }

    for(i in s.indices){
        val ch = s[i]
        val count = freq.getOrDefault(ch, 0)
        if(count == 0){
            //first most occurrence
            leftArr[ch - 'a'] = i
        } else {
            rightArr[ch - 'a'] = i
        }
        freq[ch] =  count + 1
    }


    for(i  in 0..25){
        val left = leftArr[i]
        val right = rightArr[i]
        val ch = (97 + i).toChar()
        val charFreq = freq.getOrDefault(ch, 0)
        if(charFreq == 0 || charFreq == 1) break

        val substr = right - left + 1
        if(charFreq > substr / 2) {
            println("${left + 1} ${right + 1}")
            return
        }

    }

}
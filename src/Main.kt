
fun main(){

    fun numberOfSpecialChars(word: String): Int {

        val lowerCase = IntArray(26) { Int.MIN_VALUE}
        val upperCase = IntArray(26) { Int.MAX_VALUE }

        for(i in word.indices){
            val ch = word[i]
            if(ch in 'a'..'z'){
                lowerCase[ch - 'a'] = i
            } else {
                upperCase[ch - 'A'] = minOf(upperCase[ch - 'A'], i)
            }
        }

        var count = 0
        for(i in 0 until 26){
            if(lowerCase[i] != Int.MIN_VALUE && upperCase[i] != Int.MAX_VALUE
                && lowerCase[i] < upperCase[i]){
                count++
            }
        }

        return count
    }
}

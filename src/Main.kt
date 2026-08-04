
fun fesCheck(freq : Map<Char, Int>) : Boolean {
    var maxFreq = Int.MIN_VALUE
    var sum = 0

    for(x in freq.values){
        sum += x
        maxFreq = maxOf(maxFreq, x)
    }

    return maxFreq <= (sum - maxFreq) + 1
}

fun main() {
    val str = readLine()!!
    var prev = '0'
    val sb = StringBuilder()

    //build freq
    val freq = HashMap<Char, Int>()
    for(ch in str){
        freq[ch] = freq.getOrDefault(ch, 0) + 1
    }

    //try building res from ascending a.z for lex min
    for(letter in 'A'..'Z'){
        //default conditions
        if((freq[letter] ?: 0) == 0) continue
        if(prev == letter) continue

        //try with curr letter
        freq[letter] = freq[letter]!! - 1
        if(fesCheck(freq)){
            sb.append(letter)
            break
        }

        //if not possible, undo try
        freq[letter] = freq[letter]!! - 1

    }

    println(sb.toString())
}
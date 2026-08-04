
fun fesCheck(freq : Map<Char, Int>, prev : Char = '0') : Boolean {
    var maxFreq = Int.MIN_VALUE
    var letter = '0'
    var sum = 0

    for((key, value) in freq){
        sum += value
        maxFreq = if(maxFreq > value){
            maxFreq
        } else {
            letter = key
            value
        }

    }

    return maxFreq <= (sum + 1)/2 && prev != letter
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
    //intial check for whole fesibility
    if(!fesCheck(freq)) {
        println(-1)
        return
    }

    //try building res from ascending a.z for lex min
    repeat(str.length) {
        var flag = false
        for (letter in 'A'..'Z') {
            //default conditions
            if ((freq[letter] ?: 0) == 0) continue
            if (prev == letter) continue

            //try with curr letter
            freq[letter] = freq[letter]!! - 1
            if (fesCheck(freq)) {
                sb.append(letter)
                prev = letter
                flag = true
                break
            }

            //if not possible, undo try
            freq[letter] = freq[letter]!! + 1

        }
        if(!flag) {
            return@repeat
        }
    }

    println(sb.toString())
}
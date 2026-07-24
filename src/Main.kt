
fun main() {
    fun romanToInt(s: String): Int {
        val map = mapOf<Char, Int>(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000
        )
        var sum = 0

        for(i in 0 until s.length - 1) {
            val currCh = s[i]
            val nxtCh = s[i+1]
            val currVal = map[currCh]!!
            val nxtVal = map[nxtCh]!!

            if(currVal >= nxtVal) {
                sum += currVal
            } else {
                sum -= currVal
            }

        }
        return sum + map[s[s.length - 1]]!!
    }
}
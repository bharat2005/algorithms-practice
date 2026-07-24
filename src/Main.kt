
fun main() {
    fun romanToInt(s: String): Int {
        val map = mapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000
        )
        var sum = map[s[0]]!!

        for(i in s.indices){
            val prevCh = s[i-1]
            val currCh = s[i]
            val preVal = map[prevCh]!!
            val currVal = map[currCh]!!

            if(preVal >= currVal){
                sum += currVal
            } else {
                sum -= preVal
                sum += currVal - preVal
            }

        }

        return sum
    }
}
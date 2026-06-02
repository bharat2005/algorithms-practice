fun main() {
    fun earliestFinishTime(landStartTime: IntArray, landDuration: IntArray, waterStartTime: IntArray, waterDuration: IntArray): Int {

        var min = Int.MAX_VALUE
        for(i in landStartTime.indices){
            for(j in waterStartTime.indices){
                val a = landStartTime[i]
                val b = landDuration[i]

                val x = waterStartTime[j]
                val y = waterDuration[j]

                // maxOf( a + b , x ) + y
                // maxOf( x + y, a ) + b
                val m = maxOf(a + b, x) + y
                val n =  maxOf( x + y, a ) + b

                min = minOf(m, n, min)

            }
        }
        return min
    }
}
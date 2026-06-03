fun main() {
    fun earliestFinishTime(landStartTime: IntArray, landDuration: IntArray, waterStartTime: IntArray, waterDuration: IntArray): Int {
        val n = landStartTime.size
        val m = waterStartTime.size

        var ans1 = Int.MAX_VALUE
        for(i in 0 until n){
            ans1 = minOf(
                ans1,
                landStartTime[i] + landDuration[i]
            )
        }

        var ans2 = Int.MAX_VALUE
        for(i in 0 until m){
            ans2 = minOf(
                maxOf(ans1, waterStartTime[i]) + waterDuration[i],
                ans2
            )
        }


        var ans3 = Int.MAX_VALUE
        for(i in 0 until m){
            ans3 = minOf(
                ans3,
                waterStartTime[i] + waterDuration[i]
            )
        }

        var ans4 = Int.MAX_VALUE
        for(i in 0 until n){
            ans4 = minOf(
                maxOf(ans3, landStartTime[i]) + landDuration[i],
                ans4
            )
        }
        return minOf(ans2, ans4)
    }
}
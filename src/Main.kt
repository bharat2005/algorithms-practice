
fun main() {
    fun firstStableIndex(nums: IntArray, k: Int): Int {
        val n = nums.size

        val minArr = IntArray(n)
        minArr[n - 1] = nums[n - 1]
        for (i in n - 2 downTo 0) {
            val curr = nums[i]
            if (curr < minArr[i + 1]) {
                minArr[i] = curr
            } else {
                minArr[i] = minArr[i + 1]
            }
        }

        var runningMax = Int.MIN_VALUE
        for (i in 0 until n) {
            runningMax = maxOf(runningMax, nums[i])
            val score = runningMax - minArr[i]
            if(score <= k) return i
        }



        return -1

    }
}
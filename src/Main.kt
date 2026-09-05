
fun main() {
    fun firstStableIndex(nums: IntArray, k: Int): Int {
        val n = nums.size

        //build min arr
        val minArr = IntArray(n)
        minArr[0] = nums[0]
        for(i in 1 until n){
            val curr = nums[i]
            if(curr < minArr[i-1]){
                //new min
                minArr[i] = curr
            } else {
                //old min
                minArr[i] = minArr[i-1]
            }
        }

        //build max arr
        val maxArr = IntArray(n)
        maxArr[n-1] = nums[n-1]
        for(i in n-2 downTo 0){
            val curr = nums[i]
            if(curr > maxArr[i+1]){
                //new max
                maxArr[i] = curr
            } else {
                //old max
                maxArr[i] = maxArr[i+1]
            }
        }


        for(i in 0 until n){
            val score = maxArr[i] - minArr[i]
            if(score <= k){
                return i
            }
        }

        return 0

    }
}
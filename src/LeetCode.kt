


fun peakValleyDifference(nums: IntArray): Int {
    val n = nums.size
    var peakSum = 0
    var vallySum = 0

    for(i in 1 until n - 1){
        val prev = nums[i-1]
        val curr = nums[i]
        val next = nums[i+1]
        
        if(curr > prev && curr > next) peakSum++
        if(curr < prev && curr < next) vallySum++

    }

    return peakSum - vallySum

}
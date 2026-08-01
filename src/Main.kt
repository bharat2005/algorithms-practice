
fun main() {
    fun predictTheWinner(nums: IntArray): Boolean {
        var p1 = 0
        var p2 = 0
        var start = 0
        var end = nums.size - 1
        var p1turn = true

        while(start <= end){
            if(nums[start] >= nums[end]){
                if(p1turn) p1+= nums[start++] else p2 += nums[start++]
            } else {
                if(p1turn) p1+= nums[end--] else p2 += nums[end--]
            }
            p1turn = !p1turn
        }



        return p1 >= p2

    }
}




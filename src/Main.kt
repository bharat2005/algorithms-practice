fun main() {



    fun minimumCost(cost: IntArray): Int {
        val ncost = cost.sorted()
        val n = ncost.size

        var money = 0
        var left = 0
        var right = n - 1


        while(left < right && left in 0..n-1 && right in 0..n-1){
            money += ncost[left] + ncost[right]
            right -= 2
            left--
        }


        if(ncost.size % 2 != 0 && left in 0..n-1){
            money += ncost[left]
        }

        return money
    }


}
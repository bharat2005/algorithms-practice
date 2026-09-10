
//atc - bloacked matrx
fun main1() {
    val (h,w,a,b) = readLine()!!.split(" ").map { it.toInt() }
    var res = 0
    val MOD = 1_000_000_007

    fun fac(num : Int) : Int {
        if(num <= 1) return 1
        return num * fac(num - 1)
    }


    for(e in (b+1)..w){
        val n1 = h - a + e - 2
        val r1 = h - a - 1
        val c1 = fac(n1) / ( fac(r1) * fac(n1 - r1)  )

        val n2 = a + w - 1 - e
        val r2 = a - 1
        val c2 = fac(n2) / ( fac(r2) * fac(n2 - r2) )


        res += c1 * c2
    }

    println(res % MOD)

}


//lc - node avg ct
fun main() {
    fun averageOfSubtree(root: TreeNode?): Int {
        var ct = 0

        fun dfs(node: TreeNode?): List<Int> {
            if (node == null) return listOf(0, 0) // sum and denom

            val curr = node.`val`
            val (sum1, den1) = dfs(node.left)
            val (sum2, den2) = dfs(node.right)

            val currSum = (sum1 + sum2 + curr)
            val currDen = (den1 + den2 + 1)
            val currAvg = currSum / currDen

            if (currAvg == curr) ct++
            return listOf(currSum, currDen)
        }

        val (a, b) = dfs(root)

        return ct

    }
}






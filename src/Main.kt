
fun main() {
    fun shortestBeautifulSubstring(s: String, k: Int): String {
        val n = s.length

        //build prefix sum arr
        val pfx = IntArray(n)
        pfx[0] = if(s[0] == '1') 1 else 0
        for(i in 1 until n){
            val curr = if(s[i] == '1') 1 else 0
            pfx[i] = curr + pfx[i-1]
        }


        //try every substring
        var min = Int.MAX_VALUE
        var start = -1
        var end = -1
        for(i in 0 until n-1){
            for(j in i+1 until n){
                val left = if(i == 0) 0 else pfx[i-1]
                val diff = pfx[j] - left
                if(diff == k){
                    if(diff < min){
                        min = diff
                        start = i
                        end = j
                    }
                } else if(diff > k){
                    break
                }
            }
        }

        return if(start != -1 && end != -1) s.substring(start,end) else ""
    }
}



  class TreeNode(var `val`: Int) {
     var left: TreeNode? = null
      var right: TreeNode? = null
 }




fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    val sbp = StringBuilder()
    val sbq = StringBuilder()

    fun dfs(node : TreeNode?, sb: StringBuilder) {
        if(node == null) return

        dfs(node.left, sb)
        sb.append(node.`val`)
        dfs(node.right, sb)
    }
    dfs(p, sbp)
    dfs(q, sbq)

    return sbp.toString() == sbq.toString()

}
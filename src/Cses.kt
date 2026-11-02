
fun main() {
    val matrix = Array(8) { IntArray(8)}
    val n = matrix.size
    val dig1 = BooleanArray(2 * n - 1)
    val dig2 = BooleanArray(2 * n - 1)
    val column = BooleanArray(n)
    var count = 0

    fun isSafe(row : Int, col : Int) : Boolean {
        if(column[col]) return false
        if(dig1[row + col]) return false
        if(dig2[row - col + n - 1]) return false
        return true
    }
    fun rec(r : Int){
        if(r == n) {
            count++
            matrix.forEach { println(it.joinToString(" "))}
            println()
            return
        }

        for(col in 0 until n){
            if(isSafe(r, col)){
                //place
                matrix[r][col] = 1
                column[col] = true
                dig1[r + col] = true
                dig2[r - col + n - 1] = true

                //recursion
                rec(r + 1)

                //backtrack
                matrix[r][col] = 0
                column[col] = false
                dig1[r + col] = false
                dig2[r - col + n - 1] = false
            }
        }
    }
    rec(0)
    println(count)
}
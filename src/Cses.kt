
fun main() {
    val matrix = Array(4) { IntArray(4){ 0 } }
    val n = matrix.size
    val dg1 = BooleanArray(2 * n - 1){ false }
    val dg2 = BooleanArray(2 * n - 1){ false }
    val column = BooleanArray(n){ false }

    fun isSafe(r : Int, c : Int) : Boolean {
        return !dg2[r - c + n - 1] && !dg1[r + c] && !column[c]
    }


    fun rec(r : Int) {
        if(r == 4) {
            //done
            matrix.forEach { println(it.joinToString(" ")) }
            println()
            println()
            return
        }
        for(col in 0 until 4){

            //if safe
            if(isSafe(r, col)){
                //place
                matrix[r][col] = 1
                column[col] = true
                dg1[col + r] = true
                dg2[col - r + n - 1] = true

                //next row
                rec(r + 1)

                //try next possible -> undo
                matrix[r][col] = 0
                column[col] = false
                dg1[col + r] = false
                dg2[col - r + n - 1] = false

            }

        }
    }

    rec(0)
}
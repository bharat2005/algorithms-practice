fun main() {
    val n = 5
    val chess = Array(n) { IntArray(n) { 0 } }

    val dig1 = BooleanArray(n * 2 - 1) { false }
    val dig2 = BooleanArray(n * 2 - 1) { false }
    val columns = BooleanArray(n) { false }

    var ct = 0

    fun isSafe(row : Int, col : Int) : Boolean {
        if(columns[col]) return false
        if(dig1[row + col]) return false
        if(dig2[row - col + n - 1]) return false
        return true
    }
    fun rec(row  : Int){

        if(row == n){
            ct++
            return
        }

        for(col in 0 until n){
            if(isSafe(row, col) && chess[row][col] != 2){ //2 means blocked cell

                //place queen
                dig1[row + col] = true
                dig2[row - col + n - 1] = true
                columns[col] = true
                chess[row][col] = 1

                //recurse
                rec(row + 1)

                //undo
                dig1[row + col] = false
                dig2[row - col + n - 1] = false
                columns[col] = false
                chess[row][col] = 0


            }
        }
    }

    rec(0)
    println(ct)



}

fun main() {
    val matrix = Array(4) { IntArray(4){ 0 } }
    matrix[0][0] = 1

    fun isSafe(r : Int, c : Int) : Boolean {
        //check upper rows
        var ur = r
        while(ur >= 0){
            if(matrix[ur][c] == 1) return false
            ur--
        }

        //check upper left digonal
        var ldr = r-1
        var ldc = c-1
        while (ldr >= 0 && ldc >= 0){
            if(matrix[ldr][ldc] == 1) return false
            ldr--
            ldc--
        }

        //check upper right digonal
        var rdr = r - 1
        var rdc = c + 1
        while (rdr != r && rdc != c){
            if(matrix[ldr][ldc] == 1) return false
            ldr--
            ldc++
        }


        //safe
        return true
    }
    fun rec(r : Int) {
        if(r == 4) {
            //done
            matrix.forEach { println(it) }
            println()
            println()
            return
        }


        for(col in 0 until 4){

            //if safe
            if(isSafe(r, col)){
                //place
                matrix[r][col] = 1

                //next row
                rec(r + 1)

                //try next possible -> undo
                matrix[r][col] = 0

            }

        }
    }

    rec(1)
}
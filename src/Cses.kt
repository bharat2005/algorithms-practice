
fun main() {
    val matrix = Array(4) { IntArray(4){ 0 } }
    val n = matrix.size

    fun isSafe(r : Int, c : Int) : Boolean {
        //check upper rows
        var ur = r - 1
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
        while (rdr >= 0 && rdc < n){
            if(matrix[rdr][rdc] == 1) return false
            rdr--
            rdc++
        }


        //safe
        return true
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

                //next row
                rec(r + 1)

                //try next possible -> undo
                matrix[r][col] = 0

            }

        }
    }

    rec(0)
}
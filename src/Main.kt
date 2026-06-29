import kotlin.math.abs

fun main() {
    val arr = Array(8) {
        readLine()!!.toCharArray()
    }
    val n = arr.size
    val column = BooleanArray(n)
    var ans = 0
    val dig1 = BooleanArray(n * 2 - 1)
    val dig2 = BooleanArray(n * 2 - 1)

    fun dfs(rowIndex : Int) : Unit {
        //Base case
        if(rowIndex == n){
            ans++
            return
        }

        //Recursive part
        for(i in 0 until n){

            //conditions --> row + column + dig1 + dig2 + extra condition
            val isExtraRestricted = arr[rowIndex][i] == '*'
            val isColumnRestricted = column[i]
            val isDig1Restricted = dig1[rowIndex + i]
            val isDig2Restricted = dig2[rowIndex - i + 7]

            if(isColumnRestricted || isDig1Restricted || isDig2Restricted || isExtraRestricted) continue


            //mark restricted
            column[i] = true
            dig1[rowIndex + i] = true
            dig2[rowIndex - i + 7] = true


            dfs(rowIndex + 1)


            //unmark
            column[i] = false
            dig1[rowIndex + i] = false
            dig2[rowIndex - i + 7] = false

        }
    }
    dfs(0)

    print(ans)

}






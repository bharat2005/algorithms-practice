
fun main(){
    val n = readLine()!!.toInt()
    val arr = Array(n){ IntArray(n) }

    for(r in 0 until n){
        for(c in 0 until n){

            val set = BooleanArray(2 * n )

            //build left set
            for(i in 0 until c){
                set[arr[r][i]] = true
            }

            //build above set
            for(i in 0 until r){
                set[arr[i][c]] = true
            }

            //assign unused mex
            var mex = 0
            while(set[mex]) mex++
            arr[r][c] = mex
        }
    }
}





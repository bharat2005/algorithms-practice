fun main() {
    val n = 4
    val forbiddenPairs = mapOf(
        1 to 2,
        3 to 4
    )
    val used = BooleanArray(n + 1){false}
    val permutation = mutableListOf<Int>()
    var ct = 0



    fun rec(num : Int){
        if(num == 1){
            rec(num + 1)
            return
        }

        if(num == n){
            //process
            ct++
            return
        }

        //explore all choices
        for(n in 2 until n){
            if(!used[n] && forbiddenPairs[n] != n + 1){
                //add
                permutation.add(n)
                used[n] = true
                rec(n + 1)


                //undo
                permutation.removeLast()
                used[n] = false
            }
        }
    }

}
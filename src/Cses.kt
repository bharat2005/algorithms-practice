
fun main() {
    val set = listOf(1,2,3)
    val n = set.size
    val choosed = BooleanArray(n) { false}
    val permutation = mutableListOf<Int>()

    fun rec(i : Int){
        if(permutation.size == n){
            println(permutation)
            return
        }


        for(i in 0 until n){
            //if choosed skip
            if(choosed[i] == true) continue

            //pick new choice
            choosed[i] = true
            permutation.add(set[i])
            rec(i + 1)

            //backtract
            choosed[i] = false
            permutation.removeLast()
        }
    }

    rec(0)
}
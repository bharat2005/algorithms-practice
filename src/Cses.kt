
fun main() {
    val set = intArrayOf(1,2,3,4,5)
    val n = set.size
    var ct = 0

    fun rec(k : Int, subset : MutableList<Int>) {
        if(k == n){
            println(subset)
            ct++
            return
        }

        rec(k+1, subset)

        subset.add(set[k])
        rec(k+1, subset)



    }

    rec(0, mutableListOf())
    println(ct)
}
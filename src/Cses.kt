fun main() {
    val n = readln().toInt()
    val s = readln().split(" ").map { it.toInt() }
    var ct = 0
    fun beautyCheck(l : Int, r : Int) : Boolean {
        var xnor = 1
        for(i in l..r){
            xnor = (xnor xor s[i]).inv()
        }

        return if(xnor > 0) true else false
    }

    for(l in 0 until n){
        for(r in l+1 until n){
            if(beautyCheck(l, r)) ct++
        }
    }

    println(ct)
}
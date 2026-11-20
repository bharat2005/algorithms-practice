fun main() {
    val n = readln().toInt()
    val s = readln().map { if(it == '1') 1 else 0 }
    var ct = 0
    fun beautyCheck(l : Int, r : Int) : Boolean {
        var xor = 0
        for(i in l..r){
            xor = xor xor s[i]
        }
        val mod = (r - l) % 2

        return xor != mod
    }

    for(l in 0 until n){
        for(r in l until n){
            if(beautyCheck(l, r)) ct++
        }
    }

    println(ct)
}
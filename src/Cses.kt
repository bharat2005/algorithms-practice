fun main() {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map { it.toLong() }

    var minXor = Long.MAX_VALUE

    val prefixArr = LongArray(n){ 0 }
    prefixArr[0] = a[0]
    for(i in 1 until n){
        prefixArr[i] = prefixArr[i - 1] or a[i]
    }

    val suffixArr = LongArray(n){ 0 }
    suffixArr[n-1] = a[n-1]
    for(i in n-2 downTo 0){
        suffixArr[i] = suffixArr[i + 1] or a[i]
    }


    fun rec(par : Int, xorSum : Long){
        if(par == n-1){
            return
        }
        val xor = prefixArr[par] xor suffixArr[par + 1]
        minXor = minOf(minXor,xor)

        for(ipar in par + 1 until n){
            rec(ipar, xor)
        }

    }

    rec(0, 0)
    println(minXor)
}
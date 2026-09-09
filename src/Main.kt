

fun main() {
    val (h,w,a,b) = readLine()!!.split(" ").map { it.toInt() }
    var res = 0
    val MOD = 1_000_000_007

    fun fac(num : Int) : Int {
        if(num == 1) return 1
        return num * fac(num - 1)
    }


    for(i in 0 until w){
        val n1 = h - a + b + i - 1
        val r1 = h - a - 1
        val c1 = fac(n1) / ( fac(r1) * fac(n1 - r1)  )

        val n2 = a + w - b - i - 2
        val r2 = a - 1
        val c2 = fac(n2) / ( fac(r2) * fac(n2 - r2) )


        res += c1 * c2


    }

    println(res % MOD)


}


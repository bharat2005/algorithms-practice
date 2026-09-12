
//atc - bloacked matrx
fun maineater() {
    val (h,w,a,b) = readLine()!!.split(" ").map { it.toInt() }
    var res = 0
    val MOD = 1_000_000_007

    fun fac(num : Int) : Int {
        if(num <= 1) return 1
        return num * fac(num - 1)
    }


    for(e in (b+1)..w){
        val n1 = h - a + e - 2
        val r1 = h - a - 1
        val c1 = fac(n1) / ( fac(r1) * fac(n1 - r1)  )

        val n2 = a + w - 1 - e
        val r2 = a - 1
        val c2 = fac(n2) / ( fac(r2) * fac(n2 - r2) )


        res += c1 * c2
    }

    println(res % MOD)

}


//cf
fun main() {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }
    val set = mutableSetOf<Int>()

    for(i in 0 until n){
        for(j in i+1 until n){
            val n1 = arr[i]
            val n2 = arr[j]
            val diff = Math.abs(n1 - n2).toDouble()
            val power = Math.log(diff) / Math.log(2.0)
            if(power == power.toInt().toDouble()) {
                set.apply {
                    add(n1)
                    add(n2)
                }
            }
        }
    }

    println(set.size)
    println(set.joinToString(" "))
}



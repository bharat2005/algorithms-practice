
//atc - bloacked matrx
fun main() {
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



fun main() {
    val n = readLine()!!.toInt()
    if(n % 2 != 0) {
        println("NO")
        return
    }
    val arr = readLine()!!.split(" ").map { it.toInt() }

    var pos = 0
    var neg = 0
    for(i in 0 until n-2){
        val curr = arr[i]
        var next = arr[i+1]

        if(-curr == -next) {
            println("NO")
            return
        }
    }

    println("YES")

}




fun main() {
    val n = readLine()!!.toInt()
    val s = readLine()!!

    var sum = 0

    fun nandOp(a : Int, b : Int)  : Int{
        if(a == b && a == 1) return 0
        return 1
    }

    for(i in 0 until n){
        var nandacc = if(s[i] == '0') 0 else 1
        sum += nandacc
        for(j in i + 1 until n){
            val end = if(s[j] == '0') 0 else 1
            nandacc = nandOp(nandacc, end)

            sum += nandacc
        }
    }

    println(sum)
}
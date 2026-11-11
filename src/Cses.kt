fun main() {
    val n = readLine()!!.toInt()
    val s = readLine()!!

    var sum = 0

    fun nandSimu(i : Int, j : Int) : Int {
        var res = 1
        if(i == 1 && j == 1) res = 0
        return res
    }

    for(i in 0 until n){
        val bitI =  if(s[i] == '1') 1 else 0
        var nand = 0
        for(j in i until n){
            val bitJ = if(s[j] == '1') 1 else 0
            if(i == j){
                nand = bitI
            } else {
                nand = nandSimu(nand, bitJ)
            }
            sum += nand
        }

    }

    println(sum)
}
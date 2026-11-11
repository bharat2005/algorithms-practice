fun main() {
    val n = readLine()!!.toInt()
    val s = readLine()!!

    var sum = 0

    for(i in 0 until n){
        val bitI =  if(s[i] == '1') 1 else 0
        var nand = 0
        for(j in i until n){
            val bitJ = if(s[j] == '1') 1 else 0
            if(i == j){
                nand = bitJ
            } else {
                nand = (nand and bitJ).inv()
            }
        }
        sum += nand
    }

    println(sum)
}
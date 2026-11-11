fun main() {
    val n = readLine()!!.toInt()
    val s = readLine()!!

    var nandac = 0

    for(i in 0 until n){
        val biti = if(s[i] == '1') 1 else 0
        var subnandac = 0
        for(j in i until n){
            val bitj = if(s[j] == '1') 1 else 0
            if(i == j) {
                nandac = (subnandac and biti).inv()
            } else {
                nandac = (subnandac and bitj).inv()
            }
        }
        nandac = (subnandac and nandac).inv()
    }

    println(nandac)
}
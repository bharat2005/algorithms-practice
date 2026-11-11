fun main() {
    val n = readLine()!!.toInt()
    val s = readLine()!!

    var nandac = 0

    for(i in 0 until n){
        val biti = if(s[i] == '1') 1 else 0
        for(j in i until n){
            val bitj = if(s[j] == '1') 1 else 0
            if(i == j) {
                nandac = (nandac and biti).inv()
            } else {
                nandac = (nandac and bitj).inv()
            }
        }
    }
    
    println(nandac)
}
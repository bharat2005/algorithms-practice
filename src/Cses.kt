fun main() {
    val n = readLine()!!.toInt()
    //(sub - mask) and mask
    var sub = 0

    while(true){
        println(sub)
        if(sub == n) break
        sub = (sub - n) and n
    }
}
fun main() {
    val n = readLine()!!.toLong()
    //(sub - mask) and mask
    var sub = 0L

    while(true){
        println(sub)
        if(sub == n) break
        sub = (sub - n) and n
    }
}
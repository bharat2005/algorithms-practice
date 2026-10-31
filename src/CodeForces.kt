fun main (){
    val t = readLine()!!.toInt()

    repeat(t){
        val (n,m,r,l) = readLine()!!.split(" ").map { it.toInt() }
        var ct = 0
        repeat(m){
            ct++
        }
        println(ct)
    }
}
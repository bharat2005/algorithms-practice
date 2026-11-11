fun main() {
    val n = readLine()!!.toInt()
    val s = readLine()!!

    var sum = 0

    for(i in 0 until n){
        var nandacc = if(s[i] == '0') 0 else 1
        for(j in i + 1 until n){
            val end = if(s[j] == '0') 0 else 1
            nandacc = (nandacc and end).inv()

            sum += nandacc
        }
    }

    println(sum)
}
fun main() {
    var n = readLine()!!.toLong()
    var ct = 0

    while ( n > 1){
       n =  n shr 1
        ct++
    }

    println(ct)
}
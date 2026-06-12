import kotlin.math.pow

fun main() {
//    val t = readLine()!!.toInt()
//
//    repeat(t){
//        var n = readLine()!!.toInt()
        var n = 5009
        val len = n.toString().length
        var f = len
        val arr = mutableListOf<Double>()

        while(n != 0){
            val lastDigit = n % 10
            println(lastDigit)

            arr.add(lastDigit * 10.0.pow(len - f))
            n /= 10
            f++
        }

        arr.reversed().forEach{println(it.toInt())}
//    }

}






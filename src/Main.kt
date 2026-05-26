import kotlin.math.pow

fun main(){
    val n = readLine()!!.toInt()

    for(i in 0..2.0.pow(n).toInt()) {
        val gray = i xor (i shr 1)
        println(gray.toString().padStart(n, '0'))
    }
}

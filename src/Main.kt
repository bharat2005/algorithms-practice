import kotlin.math.pow

fun main(){
    val n = readLine()!!.toInt()

    for(i in 0 until 2.0.pow(n).toInt()) {
        val gray = i xor (i shr 1)
        val str = StringBuilder()

        for(j in 0 until n){
            if((gray shr j) and 1 == 1){
                str.append("1")
            } else {
                str.append("0")
            }
        }

        println(str.toString())
    }
}

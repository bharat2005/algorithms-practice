import kotlin.math.pow

fun main() {
    val t = readLine()!!.toInt()
    repeat(t) {
        val n = readLine()!!.toInt()
        var sum = readLine()!!.split(" ").map { it.toInt() }.sum()
        for(i in 1..sum){
            if(i.toDouble().pow(i) == sum.toDouble()){
                println("YES")
            }
            break
        }

    }
}
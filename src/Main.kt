import java.util.Locale
import java.util.Locale.getDefault

fun main(){
    val n = readLine()!!.toInt()
    val map = HashMap<String,Int>()
    var max = Int.MIN_VALUE

    repeat(n){
        val str = readLine()!!.lowercase()
        val nVal =map.getOrDefault(str,0) + 1
        map[str] = nVal
        max = maxOf(max,nVal)

    }

    println(max)

}
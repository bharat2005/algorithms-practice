import java.util.Scanner

fun main() {
    val t = readLine()!!.toInt()
    
    repeat(t){
        val n = readLine()!!.toInt()
        val arr = readLine()!!.split(" ").map { it.toInt() }
        val min = arr.min()
        val max = arr.max()
        val middle = ((max - min) + 1) / 2
        println(middle)
    }
    
}

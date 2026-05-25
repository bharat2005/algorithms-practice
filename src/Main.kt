import kotlin.math.max
import kotlin.math.min

fun main(){
    val t = readLine()!!.toInt()

    repeat(t){
        val (x, y) = readLine()!!.split(" ").map { it.toInt() }

        if((x+y)%3==0 && (2* min(x,y) >= max(x,y))){
            println("YES")
        } else {
            println("NO")
        }
    }
}
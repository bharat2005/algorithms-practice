import java.util.Scanner
import kotlin.math.pow

fun main() {
    val n = readLine()!!.toInt()
    val set = readLine()!!.split(" ").map { it.toInt() }
    
    
    //3s
    for(x in set){
        var i = 1
    
        while(i <= 2.0.pow(30.0)){
            if(x in set && x+i in set && x+2*i in set){
                println(3)
                println("${x} ${x+i} ${x+2*i}")
                return
            }
            i *= 2
        }
    
    }
    
    //2s
    for(x in set){
        var i = 1
    
        while(i <= 2.0.pow(30)){
            if(x in set && x+i in set){
                println(2)
                println("${x} ${x+i}}")
                return
            }
            i *= 2
        }
    
    }
    
    
    
    println(1)
    println(set[0])
    
    
}

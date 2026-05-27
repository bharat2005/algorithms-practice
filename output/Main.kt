import java.util.Scanner

fun main() {
    val n = readLine()!!.toInt()
    val str = readLine()!!
    
    var currLen = 1
    var maxLen = 0
    for(i in 1 until n){
        if(str[i] == 'x' && str[i-1] == 'x' ){
            currLen++
        } else{
            currLen = 1
        }
    
        maxLen = maxOf(currLen, maxLen)
    }
    
    val res = if(maxLen == 1) 0 else maxLen - 2
    println(res)
}

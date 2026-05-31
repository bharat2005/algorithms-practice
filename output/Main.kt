import java.util.Scanner

fun main() {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toLong() }
    
    
    var left = 0
    var right = n - 1
    
    var aliceTime = 0L
    var bobTime = 0L
    
    var aliceCount = 0
    var bobCount = 0
    
    while(left <= right){
        if(aliceTime <=  bobTime){
            aliceTime += arr[left]
            left++
    
            aliceCount++
        } else {
            bobTime += arr[right]
            right--
    
            bobCount++
        }
    }
    
    
    println("$aliceCount $bobCount")
    
}

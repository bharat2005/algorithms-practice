import java.util.Scanner

fun main() {
    val (n, l, r, x) = readLine()!!.split(" ").map { it.toInt() }
    val a = readLine()!!.split(" ").map { it.toInt() }
    var ct = 0
    
    for(mask in 0 until (1 shl n)){
        var sum = 0
        var minNum = Int.MAX_VALUE
        var maxNum = Int.MIN_VALUE
        var size = 0
        for(i in 0 until n){
            if(mask and (1 shl i) != 0){
                val ele = a[i]
                sum += ele
                minNum = minOf(minNum, ele )
                maxNum = maxOf(maxNum, ele )
                size++
            }
        }
    
    
    
        if(sum in l..r && maxNum - minNum >= x && size >= 2) ct++
    }
    
    println(ct)
}

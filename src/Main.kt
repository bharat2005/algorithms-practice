import kotlin.math.abs

fun main(){
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }.sorted()
//    val n = 5
//    val arr = intArrayOf(3, 2, 7, 4, 1).sortedDescending()

    var g1 = arr[0]
    var g2 = arr[1]

    for( i in 2 until n){
        val num = arr[i]
        if(abs(g1 + num - g2 ) < abs(g2 + num - g1)){
         //   println("${abs(g1 + num - g2 )} < ${abs(g2 + num - g1)}")
            g1 += num
        } else {
         //   println("${abs(g1 + num - g2 )} > ${abs(g2 + num - g1)}")
           g2 += num
        }
    }

    println(abs(g1 - g2))
}


import kotlin.math.abs

fun main(){
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }
    if(n <= 2){
        println(0)
        return
    }

    var min = Int.MAX_VALUE

    for(c1 in -1..1){
        for(c2 in -1..1){
            val first = arr[0] + c1
            val second = arr[1] + c2
            val diff = second - first

            var ops = 0
            if(c1 != 0){
                ops++
            }
            if(c2 != 0){
                ops++
            }

            var prev = second
            for(i in 2 until n){
                val req = prev + diff
                val curr = arr[i]

                if(abs(req - curr) == 1){
                    ops++
                    prev = curr + (req - curr)
                } else if(abs(req - curr) == 0){
                    prev = curr
                } else {
                    break
                }
                if(i == n-1){
                    min =minOf(ops, min)
                }
            }
        }
    }

    println(if(min == Int.MAX_VALUE) -1 else min)

}

fun main2() {


//    var min = Int.MAX_VALUE
//
//    fun dfs(index : Int, prev : Int, ops : Int, diff : Int){
//        if(index == n){
//            min = minOf(min, ops)
//            return
//        }
//        val curr = arr[index]
//        val d1 = curr - prev
//        val d2 = curr + 1 - prev
//        val d3 = curr - 1 - prev
//
//        if(diff == d1 ){
//            dfs(index + 1, curr, ops, diff)
//        } else if(diff == d2){
//            dfs(index + 1, curr + 1, ops+1, diff)
//        } else if(diff == d3){
//            dfs(index + 1, curr - 1, ops+1, diff)
//        }
//    }
//
//
//
//    val curr1 = arr[0]
//    val curr2 = curr1 + 1
//    val curr3 = curr1 - 1
//
//    val next1 = arr[1]
//    val next2 = next1 + 1
//    val next3 = next1 - 1


//    //curr1
//    dfs(1,curr1, 0, next1 - curr1 )
//    dfs(1,curr1, 0, next2 - curr1 )
//    dfs(1,curr1, 0, next3 - curr1 )
//
//    //curr2
//    dfs(1,curr2, 1, next1 - curr2 )
//    dfs(1,curr2, 1, next2 - curr2 )
//    dfs(1,curr2, 1, next3 - curr2 )
//
//    //curr3
//    dfs(1,curr3, 1, next1 - curr3 )
//    dfs(1,curr3, 1, next2 - curr3 )
//    dfs(1,curr3, 1, next3 - curr3 )


    println(if(min == Int.MAX_VALUE) -1 else min)
}
package problems.b_facetook_priority_wall

import java.util.Scanner

fun main() {
    val me = readLine()!!
    val n = readLine()!!.toInt()
    val map = mutableMapOf<String, Int>()
    val set = mutableSetOf<String>()

    repeat(n){
        val arr = readLine()!!.split(" ")
        val x = arr[0]
        val action = arr[1]
        val y = if(arr[1] == "likes"){
            arr[2].removeSuffix("'s")
        } else
        {
            arr[3].removeSuffix("'s")
        }
        val priority = when(action){
            "likes" -> 5
            "commented" -> 10
            "posted" -> 15
            else -> 0
        }


        if(me == x) {
            map[y] = map.getOrDefault(y, 0) + priority
        } else if(me == y) {
            map[x] = map.getOrDefault(x, 0) + priority
        }

        set.add(x)
        set.add(y)

    }

    //positive priority list sorted
    set.filter{ it !== me }.sortedWith (
        compareByDescending<String> { map.getOrDefault(it, 0) }.thenBy { it }
    ).forEach{ println(it) }

}
package problems.a_diverse_team

import java.util.Scanner

fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val arr = readLine()!!.split(" ").map { it.toInt() }
    val used = mutableListOf<Int>()
    val res = mutableListOf<Int>()


    for(i in arr.indices){
        if(arr[i] !in used){
            res.add(i + 1)
            used.add(arr[i])
        }
    }

    if(res.size >= k){
        println("YES")
        for(i in 0 until k){
            print("${res[i]}" + " ")
        }
    } else {
        println("NO")
    }


}
package problems.a_adjacent_replacements

import java.util.Scanner

fun main() {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }.toMutableList()

    for(i in 1..arr[n-1] step 2) {
        for(j in 0 until n){
            if(arr[j] == i){
                arr[j] = i + 1
            }
            if(arr[j] == i + 1){
                arr[j] = i
            }
        }

    }


    arr.forEach { print("$it ") }
}

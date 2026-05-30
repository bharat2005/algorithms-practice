package problems.c_alice_bob_and_chocolate

import java.util.Scanner

fun main() {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toLong() }

    //create pfx sum arr
    val pfxSum = LongArray(n)
    pfxSum[0] = arr[0]
    for(i in 1 until n){
        pfxSum[i] = arr[i] + pfxSum[i - 1]
    }

    //targeted middle value
    val target = pfxSum[n-1] / 2

    //binary search
    var right = n-1
    var left = 0
    var ans = Int.MAX_VALUE
    while(left <= right){
        var mid = left + (right - left) / 2

        if(target <= pfxSum[mid]){
            ans = mid
            right = mid - 1
        } else {
            left = mid + 1
        }
    }

    println("${ans} ${n - ans}")

}

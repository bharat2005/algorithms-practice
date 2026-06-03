package problems.a_division

import java.util.Scanner

fun main() {
    val t = readLine()!!.toInt()

    repeat(t){
        val rating = readLine()!!.toInt()
        when{
            rating >= 1900 -> println("Division 1")
            rating in 1600..1899 -> println("Division 2")
            rating in 1400..1599 -> println("Division 3")
            else -> println("Division 4")
        }
    }
}

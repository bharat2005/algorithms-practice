package problems.d_points_and_powers_of_two

import java.util.Scanner
import kotlin.math.pow

fun main(){
    val n = readLine()!!.toInt()
    val set = readLine()!!.split(" ").map { it.toInt() }


    //3s
    for(x in set){
        var twos = 1L

        while(twos <= (1L shl 30)){
            if(x in set && (x+twos) in set && x+2*twos in set){
                println(3)
                println("${x} ${x+twos} ${x+2*twos}")
                return
            }
            twos *= 2
        }

    }

    //2s
    for(x in set){
        var twos = 1L

        while(twos <= (1L shl 30)){
            if(x in set && x+twos in set){
                println(2)
                println("${x} ${x+twos}}")
                return
            }
            twos *= 2
        }

    }



    println(1)
    println(set[0])


}



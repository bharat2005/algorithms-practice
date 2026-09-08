

fun main() {
    val t = readLine()!!.toInt()

    repeat(t){
        val n = readLine()!!.toInt()
        val arr = readLine()!!.split(" ").map { it.toInt() }
        var need = 0
        if(arr[0] == 1) need++
        if(arr[n-1] == 1) need++

        var zeros= 0
        for(x in arr){
            if(x == 0) zeros++
        }

        if(zeros >= 2) println(need) else println(-1)

    }


}


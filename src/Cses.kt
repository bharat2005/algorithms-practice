fun main() {
    var n = readLine()!!.toInt()

    for(subset in 0 until (1 shl n)){
        for(i in 0 until n-1){
            if(subset and (1 shl i) == 1) print(1)
        }
    }
}

fun genAllSubmask(){
    var mask = readLine()!!.toInt()
    var sub = mask

    while(true){
        println(sub)
        if(sub == 0) break
        sub = (sub - 1) and mask
    }
}
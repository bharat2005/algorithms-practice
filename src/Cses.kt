fun main() {
    val (n, l, r, x) = readLine()!!.split(" ").map { it.toInt() }
    val a = readLine()!!.split(" ").map { it.toInt() }
    var ct = 0

    for(mask in 0 until (1 shl n)){
        var sum = 0
        for(i in 0 until n){
            if(mask and (1 shl i) != 0){
                sum += a[i]
            }
        }

        val min = 31 - Integer.numberOfLeadingZeros(mask)
        val max = Integer.numberOfTrailingZeros(mask)



        if(sum in l..r && a[max] - a[min] >= x) ct++
    }

    println(ct)
}

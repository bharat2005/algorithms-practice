fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val arr = Array(n){""}
    for(i in 0 until n){
        arr[i] = readln()
    }

    var max = Int.MIN_VALUE
    //check all subset
    for(mask in 0 until (1 shl n)){
        val freq = IntArray(26){ 0 }

        //check all strings
        for(i in 0 until n){
            if(mask and (1 shl i) != 0){

                //check all chars
                val str = arr[i]
                for(ch in str) freq[ch - 'a']++

            }
        }
        var ct = 0
        for(z in freq) if(z == k) ct++
        max = maxOf(max, ct)
    }
    println(max)
}
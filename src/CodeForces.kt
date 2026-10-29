fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val arr = readLine()!!.split(" ").map { it.toInt() }

    val minDeq = ArrayDeque<Int>() //asending
    val maxDeq = ArrayDeque<Int>() //desending
    var left = 0
    var bestLen = Int.MIN_VALUE

    val res = StringBuilder()

    for(i in 0 until n){

        //maintian min asending que
        while (minDeq.isNotEmpty() && arr[minDeq.last()] >= arr[i]) minDeq.removeLast()
        minDeq.addLast(i)

        //maintain max descding que
        while(maxDeq.isNotEmpty() && arr[maxDeq.last()] <= arr[i]) maxDeq.removeLast()
        maxDeq.addLast(i)


        //shrink left as per validity andd move to next min/max
        while(arr[maxDeq.first()] - arr[minDeq.first()] > k) {
            if(left == minDeq.first()) {
                minDeq.removeFirst()
            }
            if(left == maxDeq.first()){
                maxDeq.removeFirst()
            }
            left++
        }


        //update res as per the new or old len so ffar
        val length = i - left + 1
        if(length > bestLen){
            //if got beeter len then restart len
            bestLen = length
            res.clear()
            res.append("${left + 1} ${i + 1}\n")
        } else if(length == bestLen){
            //continue iwth so far best len
            res.append("${left + 1} ${i + 1}\n")
        }

    }
    println("${bestLen} ${res.lines().size}")
    println(res.toString())


}
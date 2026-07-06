
fun main() {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }


    val sumArray = BooleanArray(n)

    for( i in 0 until n){
        var currSum = arr[i]
        for( j in i + 1 until n){
            currSum += arr[j]
            if(currSum > n) break
            sumArray[currSum] = true
        }
    }
    var count = 0
    for(x in arr){
        if(sumArray[x]){
            count++
        }
    }


    println(count)
}







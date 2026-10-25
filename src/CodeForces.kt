fun main() {
    val t = readLine()!!.toInt()
    repeat(t){
        val arr = readLine()!!.split(" ").map { it.toInt() }
        var max = arr[0]
        var sum = max

        for(i in 1 until arr.size){
            max = maxOf(max, arr[i])
            sum += max
        }

        println(sum)
    }
}
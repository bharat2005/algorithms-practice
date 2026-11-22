fun main(){
    val t = readLine()!!.toInt()
    repeat(t){
        val n = readLine()!!.toLong()
        var sum = 0L

        for(i in 0 until n-1){
            sum += (i xor (i+1)).countOneBits()
        }

        println(sum)
    }
}
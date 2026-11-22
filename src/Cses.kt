fun main() {
    val t = readLine()!!.toInt()
    repeat(t){
        val n = readLine()!!.toInt()
        val a = readLine()!!.split(" ").map { it.toInt() }

        val freq = mutableMapOf<Int,Int>()
        for(num in a){
            freq[num] = freq.getOrDefault(num, 0) + 1
        }

        for( count in freq.values){
            if(count % 2 != 0) {
                println("NO")
                return@repeat
            }
        }
        println("YES")
    }
}
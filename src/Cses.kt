fun main() {
    val t = readln().toInt()

    repeat(t) {
        val n = readln().toLong()
        var sum = 0L
        var num = 2L
        while(num <= n+1){
            sum += n/num
            num *= 2L
        }
        println(n + sum )
    }
}
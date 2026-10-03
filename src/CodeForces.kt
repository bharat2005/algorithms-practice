
fun main(){
    val t = readLine()!!.toInt()
    repeat(t){
        val n = readLine()!!.toInt()
        var i = 2
        while(n % i != 0 && i <= n)i++
        println(i)
        
    }
}
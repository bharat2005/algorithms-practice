
fun main() {
    val n = readLine()!!.toInt()
    for(i in 0 until n){
        Array(n){j ->
            print("${i or j} ")
        }
        println()
    }
}




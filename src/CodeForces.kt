
fun main() {
    val t = readLine()!!.toInt()

    repeat(t){
        val n = readLine()!!.toInt()
        repeat(n){
            val str = readLine()!!
            for(ch in 0 until str.length){
                if(str[ch] == '#') print("${ch + 1} ")
            }
            println()
        }
    }
}
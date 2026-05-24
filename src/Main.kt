
fun main(){
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }.toSet()

    print(arr.joinToString(" "))

}

fun main() {
    val (n , w) = readLine()!!.split(" ").map{ it.toInt() }
    val arr = readLine()!!.split(" ").map{ it.toInt() }

    var maxPossible = -1
    for(a in arr){
        maxPossible = w - a
    }

    println(maxPossible)
}


fun main() {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }

    var bnd = 10
    for(i in 0 until n){
        val x = arr[i]
        if(x > bnd){
            println("No")
            return
        }

        if(i == bnd-1) bnd += 10
    }
    println("Yes")
}

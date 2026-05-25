
fun main(){
    var (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val arr = readLine()!!.split(" ").map { it.toInt().toString() }


    while(n.toString().any { it.toString() in arr}){
        n++
    }

    println(n)

}

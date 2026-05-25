
fun main(){
    val t = readLine()!!.toInt()

    repeat(t){
        val (x, y) = readLine()!!.split(" ").map { it.toInt() }

        if( ((x+y) % 3 == 0) && ( (x % 3 == 0 && y % 3 == 0) || (x % 3 != 0 && y % 3 != 0) ) ){
            println("YES")
        } else {
            println("NO")
        }
    }
}
fun main(){
    val (a, b) = readLine()!!.split(" ").map { it.toInt() }

    if(a + b == 9) {
        println("Nine")
        return
    }
    if(a - b == 9) {
        println("Nine")
        return
    }
    if(a * b == 9) {
        println("Nine")
        return
    }
    if(a / b == 9) {
        println("Nine")
        return
    }

    println("Nein")

}
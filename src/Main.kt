
fun main() {
    val op1 = readLine()!!.toInt()
    val op2 = readLine()!!.toInt()
    val sum = op1 + op2

    //without zeros
    val op1x = op1.toString().filter { it != '0' }.toInt()
    val op2x = op2.toString().filter { it != '0' }.toInt()
    val sumx = sum.toString().filter { it != '0' }.toInt()


    if(op1x + op2x == sumx) println("YES") else println("NO")
}







fun main() {


    fun removeZeros(num : Int) : Int {
        var x = num
        var result = 0
        var dy10 = 1

        while(x > 0 ){
            val digit = x % 10
            if(digit != 0){
                result += digit * dy10
                dy10 *= 10
            }
            x /= 10
        }
        return result
    }

    val op1 = readLine()!!.toInt()
    val op2 = readLine()!!.toInt()
    val sum = op1 + op2


    if(removeZeros(op1) + removeZeros(op2) == removeZeros(sum)) println("YES") else println("NO")
}






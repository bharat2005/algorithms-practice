fun main() {
    var (a, b, x) = readLine()!!.split(" ").map { it.toInt() }

    val altOnes = Math.ceil((x + 1) / 2.0).toInt()
    val altZeros = Math.floor((x + 1) / 2.0).toInt()

    val diffZeros = a - altZeros
    val diffOnes = b - altOnes

    val result = StringBuilder()
    var curr = '0'
    for(i in 0 until x){
        val r = when(i){
            0 -> 1 + diffZeros
            1 -> 1 + diffOnes
            else -> 1
        }
        repeat(r){
            result.append(curr)
        }

        if(curr == '0') curr = '1' else curr = '0'
    }

    println(result.toString())
}
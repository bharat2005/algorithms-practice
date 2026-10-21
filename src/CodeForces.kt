fun main() {
    var (a, b, x) = readLine()!!.split(" ").map { it.toInt() }

    var altOnes : Int;
    var altZeros : Int;
    if(a > b) {
        altZeros = Math.ceil((x+1)/2.0).toInt()
        altOnes = Math.floor((x+1)/2.0).toInt()
    } else {
        altZeros = Math.floor((x+1)/2.0).toInt()
        altOnes = Math.ceil((x+1)/2.0).toInt()
    }

    val diffZeros = a - altZeros
    val diffOnes = b - altOnes

    val result = StringBuilder()
    var curr = if (a > b) '0' else '1'
    for(i in 0 until x + 1){
        val r = when(i){
            0 -> if(curr == '0') 1 + diffZeros else 1 + diffOnes
            1 -> if(curr == '0') 1 + diffZeros else 1 + diffOnes
            else -> 1
        }
        repeat(r){
            result.append(curr)
        }

        if(curr == '0') curr = '1' else curr = '0'
    }

    println(result.toString())
}
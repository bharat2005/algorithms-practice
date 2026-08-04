fun main() {
    val q = readLine()!!.toInt()

    repeat(q){
        var k = readLine()!!.toLong()
        var count = 9L
        var digits = 1L

        while(k > count * digits){
            k -=  count * digits
            count *= 10
            digits++
        }

        val num = count / 9 - 1 + k / digits
        val idxDig = if(k % digits == 0L) num.toString()[num.toString().length - 1] else (num+1).toString()[(k % digits).toInt() - 1]

        println(idxDig)

    }

}
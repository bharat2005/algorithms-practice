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

        val number = (count / 9) + (k - 1) / digits
        val digitIndex = ((k) % digits).toInt()

        println(number.toString()[digitIndex - 1])


    }

}

fun main() {
    val t = readLine()!!.toInt()

    repeat(t){
        val n = readLine()!!.toInt()
        val arr = readLine()!!.split(" ").map { it.toInt() }

        var minTwoCount = 0
        var flag = false

        for(x in arr){
            if(x >= 2) minTwoCount++

            if(minTwoCount >= 2 || x >= 3){
                flag = true
                break
            }
        }
        if(flag) {
            println("YES")
        } else {
            println("NO")
        }
    }
}







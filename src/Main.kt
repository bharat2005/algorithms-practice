
fun main() {
    val t = readLine()!!.toInt()

    repeat(t){
        val n = readLine()!!.toInt()
        val arr = readLine()!!.split(" ").map { it.toInt() }

        var minOne = false
        var minTwo = false
        var flag = false

        for(x in arr){

            if(x >= 2){
                minTwo = true
            } else if(x >= 1){
                minOne = true
            }

            if(minOne && minTwo || x >= 3){
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







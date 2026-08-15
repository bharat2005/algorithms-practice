
fun main(){
    val t = readLine()!!.toInt()

    repeat(t){
        val n = readLine()!!.toInt()
        var product= 1
        val arr = readLine()!!.split(" ").map {
            if(it.toInt() != 1 || it.toInt() != 0) product *= it.toInt()
            it.toInt()
        }.sorted()

        if(arr[0] == 0) {
            println(product)
            return
        }
        if(arr[0] == 1){
            println(product * 2)
            return
        }

        println((product / arr[n - 1]) * (arr[n-1] + 1))

    }

}
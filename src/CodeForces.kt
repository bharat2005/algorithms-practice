fun main() {
    //a = 0, b = 1
    var (a, b, x) = readLine()!!.split(" ").map { it.toInt() }
    val sb  = StringBuilder()

    //build trans
    var flag = if(a > b) true else false //true = 0, false = 1
    repeat(x + 1){
        if(flag){
            sb.append('0')
            a--
        }else{
            sb.append('1')
            b--
        }
        flag = !flag
    }


    //attach back rest
    val result = StringBuilder()
    repeat(a){
        result.append('0')
    }
    result.append(sb.toString())
    ////
    val suffix = StringBuilder()
    repeat(b){
        suffix.append('1')
    }
    result.append(suffix.toString())


    println(result.toString())




}
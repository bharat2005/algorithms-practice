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
    val prefix = StringBuilder()
    if(sb.first() == '0'){
        repeat(a) {
            prefix.append('0')
            a--
        }
    } else {
        repeat(b) {
            prefix.append('1')
            b--
        }
    }
    prefix.append(sb.toString())


    val suffix = StringBuilder()
    if(sb.last() == '0'){
        repeat(a) {
            suffix.append('0')
            a--
        }
    } else {
        repeat(b) {
            suffix.append('1')
            b--
        }
    }
    prefix.append(suffix.toString())


    println(prefix.toString())


}
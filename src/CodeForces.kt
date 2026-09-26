
fun main() {
    val t = readLine()!!.toInt()

    repeat(t){
        val s = readLine()!!
        val sb = StringBuilder()
        sb.append(s[0])
        for(i in s.indices){
            val ch = s[i]
            if(ch == ' '){
                sb.append(s[i+1])
            }
        }

        println(sb.toString())
    }

}
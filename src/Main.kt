
fun main(){
    //val str = readLine()!!
    val str = "aaab"
    val sb = StringBuilder()
    val chars = str.toCharArray().sorted()
    val bools = BooleanArray(chars.size){false}
    val res = mutableListOf<String>()

    fun rec(){
        if(sb.length == str.length){
            res.add(sb.toString())
            return
        }


        for(i in chars.indices){
            if(bools[i]) continue
            if(i > 0 && chars[i] == chars[i-1] && !bools[i-1]) continue

            bools[i] = true
            sb.append(chars[i])
            rec()
            sb.deleteCharAt(sb.length - 1)
            bools[i] = false
        }
    }

    rec()

    println(res.size)
    res.forEach { println(it) }
}

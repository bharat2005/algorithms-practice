
fun main(){
   // val str = readLine()!!
    val str = "aabac"
    val sb = StringBuilder()
    val res = mutableListOf<String>()

    val map = sortedMapOf<Char, Int>()
    for(ch in str){
        map[ch] = map.getOrDefault(ch, 0) + 1
    }

    fun rec() : Unit {
        if(sb.length == str.length){
            res.add(sb.toString())
            return
        }

        for((ch, count) in map){
            if(count == 0) continue

            map[ch] = count - 1
            sb.append(ch)
            rec()
            sb.deleteCharAt(sb.length - 1)
            map[ch] = count
        }
    }

    rec()

    println(res.size)
    res.forEach { println(it) }

}

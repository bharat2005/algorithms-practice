
fun main(){
    val str = readLine()!!
    val res = mutableListOf<String>()

    fun rec(string : String, avail : MutableList<Char>) : Unit {
        if(avail.size == 0){
            res.add(string)
            return
        }
        val nAvail = avail.toMutableList()
        for(ch in avail){
            nAvail.remove(ch)
            rec(string + ch, nAvail)
            nAvail.add(ch)
        }

    }

    rec("", str.toList().toMutableList())

    println(res.distinct().size)
    res.distinct().sorted().forEach { println(it) }

}

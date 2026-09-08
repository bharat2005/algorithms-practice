

fun main(){
    fun countCommas(n: Int): Int {
        val len = n.toString().length
        return if(len >= 4) len / 3 else 0
    }
}

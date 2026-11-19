fun main() {
    val n = readln()!!.toInt()
    val a = readln()!!.split(" ").map { it.toInt() }

    fun rec(index : Int, currentOr : Int, accumulatedXor : Int) : Int {
        if(index == n){
            return accumulatedXor xor currentOr
        }

        //new partition
        val option1 = rec(
            index + 1,
            a[index],
            accumulatedXor xor currentOr
        )

        val option2 = rec(
            index + 1,
            currentOr or a[index],
            accumulatedXor
        )


        return minOf(option1, option2)
    }

    val ans = rec(0, 0, 0)
    println(ans)
}
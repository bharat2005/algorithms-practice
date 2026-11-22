fun main() {
    val (n, l, r, x) = readLine()!!.split(" ").map { it.toInt() }
    val a = readLine()!!.split(" ").map { it.toInt() }.sorted()
    var ct = 0

    fun dfs(i : Int, sum : Int, min : Int, max : Int, size : Int){
        if(i == n){
            if(size >= 2 && sum in l..r && max - min >= x) ct++
            return
        }

        //skip
        dfs(i+1, sum, min, max, size)

        //consider
        dfs(
            i+1,
            sum + a[i],
            min = minOf(min, a[i]),
            max = maxOf(max, a[i]),
            size = size + 1
        )
    }

    dfs(0, 0, Int.MAX_VALUE, Int.MIN_VALUE, 0)

    println(ct)

}

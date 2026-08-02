
fun main() {
    val n = readLine()!!.toInt()
    val arr = Array(n){ IntArray(n){ -1 } }
    arr[0][0] = 0
    val que = ArrayDeque<Pair<Int, Int>>()
    que.add(Pair(0,0))

    val dr = listOf<Int>(2,2,-2,-2,1,-1,-1,1)
    val dc = listOf<Int>(1,-1,-1,1,2,2,-2,-2)
    while(que.isNotEmpty()) {
        val (r, c) = que.removeFirst()

        //explore all directions
        for(i in 0 until 8){
            val nr = r + dr[i]
            val nc = c + dc[i]
            if(nr !in 0..<n || nc !in 0..<n) continue

            if(arr[nr][nc] == -1){
                arr[nr][nc] = arr[r][c] + 1
                que.add(Pair(nr,nc))
            }
        }
    }

    arr.forEach{
        it.forEach { print("$it ")}
        println()
    }


}





fun main() {
    val n = readLine()!!.toInt()
    val arr = Array(n){ IntArray(n){ Int.MAX_VALUE } }
    arr[0][0] = 0
    val que = ArrayDeque<Pair<Int, Int>>()
    que.add(Pair(0,0))

    val dr = listOf<Int>(-1,1,0,0,-1,1,1,-1)
    val dc = listOf<Int>(0,0,-1,1,1,-1,1,-1)
    while(que.isNotEmpty()) {
        val (r, c) = que.removeFirst()

        //explore all directions
        for(i in 0 until 8){
            val nr = r + dr[i]
            val nc = c + dc[i]
            if(nr !in 0..<n || nc !in 0..<n) continue

            val currDist = arr[nr][nc]
            val newDist = arr[r][c] + 1
            if(newDist < currDist){
                arr[nr][nc] = newDist
            }

            que.add(Pair(nr,nc))
        }


    }

    arr.forEach{
        it.forEach { print("$it ")}
        println()
    }


}




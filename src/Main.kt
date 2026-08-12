fun main(){
    fun main() {
        val t = readln().toInt()

        repeat(t) {
            val grid = Array(8) { readln() }

            val word = StringBuilder()

            for (i in 0 until 8) {
                for (j in 0 until 8) {
                    if (grid[i][j] != '.') {
                        word.append(grid[i][j])
                    }
                }
            }

            println(word)
        }
    }

}
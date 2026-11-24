fun main() {
    val t = readln().toInt()

    repeat(t) {
        val (n, x, y) = readln().split(" ").map { it.toInt() }
        val a = readln().split(" ").map { it.toInt() }


        for (num in a) {

            val alice = x xor num == y || x + num == y
            val bob = x + 3 xor num == y || x + 3 + num == y

            if (alice) {
                println("Alice")
                return
            }
            if (bob) {
                println("Bob")
                return
            }
        }
    }
}
fun main() {
    val n = readLine()!!.toInt()

    val strings = MutableList(n) {
        readLine()!!
    }

    strings.sortBy { it.length }

    for (i in 0 until n - 1) {
        if (!strings[i + 1].contains(strings[i])) {
            println("NO")
            return
        }
    }

    println("YES")
    strings.forEach { println(it) }
}
import java.io.BufferedReader
import java.util.StringTokenizer

private class FastScanner {
    private val br = BufferedReader(System.`in`.reader())
    private var st: StringTokenizer? = null

    fun nextInt(): Int {
        while (st == null || !st!!.hasMoreTokens()) {
            st = StringTokenizer(br.readLine())
        }
        return st!!.nextToken().toInt()
    }
}

fun main() {
    val fs = FastScanner()
    val t = fs.nextInt()

    repeat(t) {
        val n = fs.nextInt()
        var a = fs.nextInt()
        var b = fs.nextInt()

        if (a + b > n || maxOf(a, b) == n) {
            println("NO")
            return@repeat
        }

        var first = IntArray(n) { it + 1 }
        var second = IntArray(n)

        var swapped = false
        if (a < b) {
            swapped = true
            val tmp = a
            a = b
            b = tmp
        }

        // Draws
        for (i in a + b until n) {
            second[i] = i + 1
        }

        // Rotation on first (a+b) positions
        val k = a + b
        for (i in 1..k) {
            var u = (i - b + k) % k
            if(u == 0) u = k
            second[i-1] = u
        }

        if (swapped) {
            val tmp = first
            first = second
            second = tmp
        }

        println("YES")
        println(first.joinToString(" "))
        println(second.joinToString(" "))
    }
}
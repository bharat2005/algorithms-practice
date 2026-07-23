
import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    val st = StringTokenizer(readln())

    val freq = IntArray(101)
    var ans = 0

    repeat(n) {
        val x = st.nextToken().toInt()
        freq[x]++
        ans = maxOf(ans, freq[x])
    }

    println(ans)
}
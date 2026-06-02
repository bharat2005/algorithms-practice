import java.lang.StringBuilder

fun main() {
    val t = readLine()!!.toInt()
    val out = StringBuilder()

    repeat(t) {
        val (n, k) = readLine()!!.split(" ").map { it.toLong() }

        if (n >= k && n % 2 == k % 2) {
            out.append("YES\n")

            repeat((k - 1).toInt()) {
                out.append("1 ")
            }
            out.append(n - (k - 1)).append('\n')

        } else if (n % 2 == 0L && n >= 2 * k) {
            out.append("YES\n")

            repeat((k - 1).toInt()) {
                out.append("2 ")
            }
            out.append(n - 2 * (k - 1)).append('\n')

        } else {
            out.append("NO\n")
        }
    }

    print(out.toString())
}
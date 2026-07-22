import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val set = HashSet<Int>()

    repeat(3) {
        set.add(st.nextToken().toInt())
    }

    println(set.size)
}
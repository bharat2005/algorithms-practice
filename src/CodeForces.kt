
fun main() {
    val times = readLine()!!.toInt()

    repeat(times) {

        val (s, t) = readLine()!!.split(" ")
        if (s.length != t.length) {
            println("NO")
            return@repeat
        }


        val freq1 = mutableMapOf<Char, Int>()
        for (ch in s) {
            freq1[ch] = freq1.getOrDefault(ch, 0) + 1
        }
        val freq2 = mutableMapOf<Char, Int>()
        for (ch in t) {
            freq2[ch] = freq2.getOrDefault(ch, 0) + 1
        }
        for (key in freq1.keys) {
            if (freq1[key] != freq2[key]) {
                println("NO")
                return@repeat
            }
        }


        println("YES")
    }
}
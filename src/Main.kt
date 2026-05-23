import kotlin.math.pow

fun main() {
    val MOD = 1_000_000_000 + 7
    val n = readLine()!!.toInt()

    var ans = 1L
    repeat(n){
        ans *= 2 % MOD
    }
    println(ans % MOD)
}
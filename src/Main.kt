
fun main(){
    val n = readLine()!!.toInt()
    var fac = 5
    var ans = 0

    while(fac <= n){
        ans += n / fac
        fac *= 5
    }

    println(ans)
}
//
//fun main() {
//    val t = readLine()!!.toInt()
//
//    for(c in 1..t){
//        val (n, a, b) = readLine()!!.split(" ").map { it.toInt() }
//        //fesibility check
//        if(a + b > n || a >= n || b >= n) {
//            println("NO")
//            continue
//        } else{
//            println("YES")
//        }
//
//        //defulat a wins permutation
//        for(i in 1..n){
//            print("${i} ")
//        }
//        println()
//
//        //dynamic b wins permutation
//        //ties if needed
//        val t = n - (a + b)
//        for(i in 1..t){
//            print("${i} ")
//        }
//
//        //rest targeted shift
//        for(i in t+1..n){
//            var u = i - b
//            if(u <= t) u = i + 1
//            print("${u} ")
//        }
//
//    }
//}


fun main(){
    val t = readLine()!!.toInt()

    repeat(t){
        val n = readLine()!!.toInt()
        if(n % 2 == 1) {
            println("NO")
            return@repeat
        }
        val ls = readLine()!!.split(" ").map { it.toInt() }
        var bigs = Int.MAX_VALUE
        var smalls = Int.MIN_VALUE

        for(i in 1 until n step 2){
            val big = ls[i-1]
            val small = ls[i]
            if(small >= big) {
                println("NO")
                return@repeat
            }

            bigs = minOf(bigs, big)
            smalls = maxOf(smalls, small)

            if(bigs - smalls > 1 && bigs > smalls){
                //valid
            } else {
                println("NO")
                return@repeat
            }

        }

        println("YES")
    }
}



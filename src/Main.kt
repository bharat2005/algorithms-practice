
fun main() {
    val t = readLine()!!.toInt()

    for(c in 1..t){
        val (n, a, b) = readLine()!!.split(" ").map { it.toInt() }
        //fesibility check
        if(a + b > n || a >= n || b >= n) {
            println("NO")
            continue
        } else{
            println("YES")
        }

        //defulat a wins permutation
        for(i in 1..n){
            print("${i} ")
        }
        println()

        //dynamic b wins permutation
        //ties if needed
        val t = n - (a + b)
        for(i in 1..t){
            print("${i} ")
        }

        //rest targeted shift
        for(i in t+1..n){
            var u = i - b
            if(u <= t) u = i + 1
            print("${u} ")
        }

    }
}




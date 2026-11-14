fun main() {
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }
    val b = readln().split(" ").map { it.toInt() }

    var x = 0
    var y = 0
    var ct = 0
    var stale = -1
    while (y < n || x < n){
        //normal shifting
        if(a[x] == b[y]) {
            x++
            y++
        } else {
            //mismatch
            if(ct == 0) {
                stale = b[y]
                y++
                ct++
            } else if(ct == 1){
                if(stale == a[x]){
                    x++
                    y++
                    ct++
                } else {
                    println("No")
                    return
                }
            } else {
                println("No")
                return
            }
        }
    }
    println("Yes")
}
fun main() {
    val n = readln().toInt()
    val k = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }
    var ans = 0

    fun memChek(mask : Int, x : Int) : Boolean {
        if(mask and (1 shl x) != 0) return true
        return false
    }

    //check all subsets
    for(s in 0 until (1 shl n)){
        var sum = 0

        //check all pairs
        for(i in 0 until n){
            //check if ele belongs to curr subset
            if(!memChek(s,i)) continue

            for(j in i + 1 until n){
                //check if ele belongs to curr subset
                if(!memChek(s,j)) continue

                sum += a[i] xor a[j]

            }
        }

        if(sum == k)ans++
    }

    println(ans)
}
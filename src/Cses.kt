fun main() {
    val n = readln().toInt()
    val s = readln().map { if(it == '1') 1 else 0 }
    var res = 0

    val prefixXor = IntArray(n){ 0 }
    prefixXor[0] = s[0]
    for(i in 1 until n){
        prefixXor[i] = prefixXor[i-1] xor s[i]
    }

    fun checkBeauty(l : Int, r : Int) : Boolean {
        val left = if(l == 0) 0 else l - 1
        return prefixXor[r] xor prefixXor[left] != (r - l) % 2
    }
    for(i in 0 until n){
        for(j in i until n){
            if(checkBeauty(i, j)) res++
        }
    }

    println(res)
}



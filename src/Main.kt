fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val arr = readLine()!!.split(" ").map { it.toInt() }
    val map = mutableMapOf<Int, Int>()


    for(i in arr.indices){
        val std = arr[i]
        map[std] = map.getOrDefault(std, 0) + 1
    }

    var ans = 0
    for(i in map.keys){
       ans++
    }

    if(ans == k){
        println("YES")
        map.keys.forEach { print(it) }
    }else {
        println("NO")
    }

}
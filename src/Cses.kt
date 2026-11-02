fun main() {
    val n = 5
    val arr = intArrayOf(2, -1, 3, 2, -2)
    val s = 3
    val k = 2

    val ss = mutableListOf<Int>()
    var count = 0

    fun rec(i : Int){
        //base case
        if(ss.size == k || i >= n){
            //process
            if(ss.size == k && ss.sum() == s) count++
            return
        }

        //include
        ss.add(arr[i])
        rec(i + 1)

        //undo
        ss.removeLast()

        //exclude
        rec(i + 1)
    }

    rec(0)


}
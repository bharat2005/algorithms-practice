fun main() {
    val (n, m, k) = readLine()!!.split(" ").map { it.toInt() }
    val tests = mutableListOf<List<String>>()
    repeat(m){
        tests.add(readln().split(" "))
    }

    var ans = 0
    //all possible subset
    for(mask in 0 until (1 shl n)){
        var valid = true

        //all tests
        for(t in 0 until m){
            var kcount = 0

            //all ele of a test
            for(i in 1 until tests[t].size - 1){
                val x = tests[t][i].toInt()
                //mem check
                if(mask and (1 shl (x-1)) != 0) kcount++
            }

            val res = tests[t].last()
            if(kcount >= k && res == "o"){
                //good going
            } else if(kcount < k && res == "x"){
                //good going
            } else {
                //its done bro
                valid = false
                break
            }


        }
        if(valid) ans++
    }
    println(ans)
}
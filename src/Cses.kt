fun main() {
    val n = 5
    val matrix = Array(n) { IntArray(n) { 0 } }
    val usedJobs = BooleanArray(n) {false}

    var min = Int.MAX_VALUE
    var ct = 0

    fun rec(worker : Int, currCost : Int){
        if(worker == n){
            //mins count
            if(min > currCost){
                //new min
                ct = 1
                min = currCost
            } else if(min == currCost){
                //old min
                ct++
            }
            println("$currCost")
            return
        }


        for(job in 0 until n){
            if(!usedJobs[job]){
                //assign job
                usedJobs[job] = true

                //recurse
                rec(worker + 1, currCost + matrix[worker][job])

                //undo
                usedJobs[job] = false
            }
        }

    }


    rec(0, 0)
    println(ct)


}
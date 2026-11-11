fun main() {
    val n = readLine()!!.toInt()
    val s = readLine()!!
    
    var sum = 0L
    var onesCount = 0L
    
    for(j in 0 until n){
        var calculatedOnes = 0L
        
        if(s[j] == '0'){
            calculatedOnes = j.toLong()
            onesCount++
        } else {
            calculatedOnes = j.toLong() + 1 - onesCount
        }
        sum += calculatedOnes
    }
    
    println(sum)
}
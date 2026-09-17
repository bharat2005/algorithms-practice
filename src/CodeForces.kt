
fun main() {
    val (s1, s2) = readLine()!!.split(" ")
    
    for(i in 0 until 3){
        if(i == 0){
            print("${s2[i]}")
        } else {
            print("${s1[i]}")
        }
    }
    print(" ")
    for(i in 0 until 3){
        if(i == 0){
            print("${s1[i]}")
        } else {
            print("${s2[i]}")
        }
    }

}
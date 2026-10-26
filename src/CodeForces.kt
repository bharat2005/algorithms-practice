fun main() {
    val t = readLine()!!.toInt()
    repeat(t){
        val s = readLine()!!.reversed()

        for(ch in s){
            if(ch == 'p'){
                print("q")
            } else if(ch == 'q'){
                print("p")
            }else {
                print("w")
            }
        }
    }
}
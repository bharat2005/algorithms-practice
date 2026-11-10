fun main(){
    val str = readLine()!!
    for(i in str.indices){
        //first case
        if(i == 0 && str[i].toInt() <= 97){
            println("No")
            return
        } else {
            if(str[i].toInt() < 97){
                println("No")
                return
            }
        }

    }

    println("Yes")
}
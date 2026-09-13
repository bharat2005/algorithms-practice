
fun main(){
    val st = readLine()!!
    val n = st.length

    for(i in st.indices){
        if(i > 0 && i < n-1 && st[i] == ' ' && st[i+1] != st[i-1]) {
            println("NO")
            return
        }
    }

    println("YES")

    
}
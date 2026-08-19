import jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyles

fun main(){
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }
    var min = Int.MAX_VALUE

    fun dfs(index : Int, prev : Int, ops : Int, diff : Int){
        if(index == n){
            min = minOf(min, ops)
            return
        }
        val curr = arr[index]
        val d1 = curr - prev
        val d2 = curr + 1 - prev
        val d3 = curr - 1 - prev

        if(diff == d1 ){
            dfs(index + 1, curr, ops, diff)
        } else if(diff == d2){
            dfs(index + 1, curr + 1, ops+1, diff)
        } else if(diff == d3){
            dfs(index + 1, curr - 1, ops+1, diff)
        }
    }


    if(arr.size == 1){
        println(-1)
        return
    }


    val curr1 = arr[0]
    val curr2 = curr1 + 1
    val curr3 = curr1 - 1

    val next1 = arr[1]
    val next2 = next1 + 1
    val next3 = next1 - 1

    //curr1
    dfs(1,curr1, 0, next1 - curr1 )
    dfs(1,curr1, 0, next2 - curr1 )
    dfs(1,curr1, 0, next3 - curr1 )

    //curr2
    dfs(1,curr2, 1, next1 - curr2 )
    dfs(1,curr2, 1, next2 - curr2 )
    dfs(1,curr2, 1, next3 - curr2 )

    //curr3
    dfs(1,curr3, 1, next1 - curr3 )
    dfs(1,curr3, 1, next2 - curr3 )
    dfs(1,curr3, 1, next3 - curr3 )


    println(if(min == Int.MAX_VALUE) -1 else min)

}
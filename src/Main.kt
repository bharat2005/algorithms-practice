
fun main(){
    val str = readLine()!!

    //store freq
    val arr = IntArray(26)
    for(char in str){
        arr[char - 'A']++
    }

    //check odd count & mid
    var oddCount = 0
    var middle : Int? = null
    for(i in arr.indices){
        if(arr[i] % 2 == 1){
            oddCount++
            middle = i
        }
    }
    if(oddCount > 1){
        println("NO SOLUTION")
        return
    }

    //create left part
    val left = StringBuilder()
    for(i in arr.indices){
        if(arr[i] % 2 == 0){
            repeat(arr[i] / 2) {
                left.append(('A'.code + i).toChar())
            }
        }
    }

    val right = left.reversed().toString()

    if(middle != null){
        repeat(arr[middle]){
            left.append(('A'.code + middle ).toChar())
        }
    }

    println(left.toString() + right)

}
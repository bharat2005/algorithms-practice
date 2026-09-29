

fun isRectangleOverlap(rec1: IntArray, rec2: IntArray): Boolean {
    val rec1bx = rec1[0]
    val rec1by = rec1[1]
    val rec1tx = rec1[2]
    val rec1ty = rec1[3]

    val rec2bx = rec2[0]
    val rec2by = rec2[1]
    if(rec2bx in (rec1bx+1)..<rec1tx && rec2by in (rec1by+1)..<rec1tx){
        return true
    }



    val rec2tx = rec2[2]
    val rec2ty = rec2[3]
    if(rec2tx in (rec1bx+1)..<rec1tx && rec2ty in (rec1by+1)..<rec1tx){
        return true
    }

    return false

}

fun addStrings(num1: String, num2: String): String {
    var fac = 1
    var res1 = 0
    val len1 = num1.length
    for(i in num1.indices){
        val ch = num1[len1 - i - 1]
        res1 += fac * ch.toInt()
        fac *= 10
    }
    fac = 1
    var res2 = 0
    val len2 = num2.length
    for(i in num2.indices){
        val ch = num2[len2 - i - 1]
        res2 += fac * ch.toInt()
        fac *= 10
    }

    return (res1 + res2).toString()
}





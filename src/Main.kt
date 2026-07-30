
fun main(){
    fun minimumPushes(word: String): Int {
        var ans = 0

        for (i in word.indices) {
            ans += (i / 8) + 1
        }

        return ans
    }

}





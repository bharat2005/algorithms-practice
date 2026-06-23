fun main() {
    val numbers = mutableListOf(5, 2, 8, 1)

    for(j in 0 until numbers.size) {
        for (i in 0 until numbers.size - 1 - j) {
            if (numbers[i] > numbers[i + 1]) {
                val temp = numbers[i]
                numbers[i] = numbers[i + 1]
                numbers[i + 1] = temp
            }
        }
    }

    println(numbers)
}






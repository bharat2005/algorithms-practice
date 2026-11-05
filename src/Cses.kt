fun main() {
    val mask = 0b1010
    var submask = 0
    while(true){
        println(submask.toString(2).padStart(4, '0'))
        if(submask == mask) break
        submask = (submask - mask) and mask
    }

}
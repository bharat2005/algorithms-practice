
fun main() {
    val (m, d) = readLine()!!.split(" ").map { it.toInt() }
    val s = readLine()!!
    var c = 0
    var i = 0

    //keep iterate over s
    while (i < m){

        if(s[i] != 'G'){
            //keep counting '.'
            c++
        } else {
            //if caught 'G' then remove m count from c
            c-= d

            //try to skip the remaining part
            var x = i
            while(i < m && i <= x + d){

                //if encountred 'G' while skipping then update x and continue skipping fromwards
                if(s[i] == 'G') {
                    x = i
                } else {
                    i++
                }

            }
        }
        i++

    }

    println(c)

}
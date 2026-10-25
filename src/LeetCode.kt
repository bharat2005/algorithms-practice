

fun isLongPressedName(name: String, typed: String): Boolean {

    var ptr1 = 0
    var ptr2 = 0

    while(ptr1 < name.length && ptr2 < typed.length) {

        while(name[ptr1] != typed[ptr2]) {
            ptr1++
            ptr2++
        }

        if(typed[ptr2] != typed[ptr2-1]) return false
    }


    return false


}
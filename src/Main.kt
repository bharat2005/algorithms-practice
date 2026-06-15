import kotlin.math.pow

 class ListNode(var `val`: Int) {
         var next: ListNode? = null
 }

fun main() {
    fun deleteMiddle(head: ListNode?): ListNode? {

        //transverse the ll and get length
        var curr = head
        var indexCount = -1
        while(curr != null){
            indexCount++
            curr = curr.next
        }

        //find middle index
        val middleIndex = indexCount / 2


        //recrreate the ll
        val newHead = head
        var xcurr = newHead
        var ncurr = head

        var indexCount2 = -1
        while(ncurr != null){
            indexCount2++

            if(indexCount2 + 1 == middleIndex){
                xcurr?.next = ncurr?.next?.next
                ncurr = ncurr?.next?.next
                xcurr = xcurr?.next

                continue
            }

            xcurr?.next = ncurr?.next
            ncurr = ncurr?.next
            xcurr = xcurr?.next
        }




        return newHead
    }
}






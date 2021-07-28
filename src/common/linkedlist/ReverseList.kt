package common.linkedlist

import common.data_structures.ListNode
import common.data_structures.createLinkedList
import common.data_structures.printLinkedList

/**
 * Stats
 * Runtime: 164 ms, faster than 69.33%
 * Memory Usage: 36.2 MB, less than 18.20%
 */
fun reverseList(head: ListNode?): ListNode? {
    var first = head
    var next = head?.next
    var lookAhead = head?.next?.next

    while (next != null) {
        head!!.next = lookAhead
        next.next = first

        first = next
        next = head.next
        lookAhead = lookAhead?.next
    }
    return first
}

fun main() {
    val input = intArrayOf(1, 2, 3, 4, 5)
    val listNode = createLinkedList(input)
    val result = reverseList(listNode)
    printLinkedList(result)
}

package data_structures.linkedlist

/**
 * leetcode - https://leetcode.com/problems/reverse-linked-list/
 *
 * Stats
 * Runtime: 164 ms, faster than 69.33%
 * Memory Usage: 36.2 MB, less than 18.20%
 */
fun reverseList(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var curr = head
    while (curr != null) {
        val lookAhead = curr.next
        curr.next = prev
        prev = curr
        curr = lookAhead
    }
    return prev
}

fun main() {
    val input = intArrayOf(1, 2, 3, 4, 5)
    val listNode = createLinkedList(input)
    val result = reverseList(listNode)
    printLinkedList(result)
}

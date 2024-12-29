package leetcode.leetcode_328_odd_even_linked_list

import data_structures_and_algorithms.linkedlist.ListNode

/**
 * leetcode - https://leetcode.com/problems/odd-even-linked-list/
 *
 * Using linked list
 *
 * Stats
 * Runtime: 319 ms, faster than 65.04%
 * Memory Usage: 39.6 MB, less than 60.16%
 */
private fun oddEvenList(head: ListNode?): ListNode? {
    if (head?.next?.next == null) {
        return head
    }
    val evenHead = head.next
    var oddPointer = head
    var evenPointer = evenHead
    while (evenPointer?.next != null) {
        oddPointer?.next = evenPointer.next
        oddPointer = oddPointer?.next
        evenPointer.next = oddPointer?.next
        evenPointer = evenPointer.next
    }
    oddPointer?.next = evenHead
    return head
}

private fun main() {

}

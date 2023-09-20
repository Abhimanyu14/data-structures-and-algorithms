package leetcode.leet_100_to_199.leet_143_reorder_list

import data_structures_and_algorithms.linkedlist.ListNode

/**
 * leetcode - https://leetcode.com/problems/reorder-list/
 *
 * Using solutions of problem 876, 206 and 21
 *
 * Stats
 * Runtime: 431 ms, faster than 75.73%
 * Memory Usage: 48.6 MB, less than 76.70%
 */
private fun reorderList(head: ListNode?): Unit {
    if (head == null) {
        return
    }

    var middlePointer = middleList(head)

    var l1 = head
    var l2 = reverseList(middlePointer)

    while (l2?.next != null) {
        val temp1 = l1?.next
        l1?.next = l2
        l1 = temp1

        val temp2 = l2?.next
        l2?.next = l1
        l2 = temp2
    }
}

private fun middleList(root: ListNode?): ListNode? {
    var middlePointer = root
    var fastPointer = root
    while (fastPointer?.next != null) {
        middlePointer = middlePointer?.next
        fastPointer = fastPointer?.next?.next
    }
    return middlePointer
}

private fun reverseList(root: ListNode?): ListNode? {
    var prev: ListNode? = null
    var current = root
    while (current != null) {
        val lookAhead = current.next
        current.next = prev
        prev = current
        current = lookAhead
    }
    return prev
}

private fun main() {

}

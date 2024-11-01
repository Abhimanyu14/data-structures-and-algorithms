package leetcode.leetcode_0_to_99.leetcode_92_reverse_linked_list_ii

import data_structures_and_algorithms.linkedlist.ListNode


/**
 * leetcode - https://leetcode.com/problems/reverse-linked-list-ii/
 *
 * Using Iterative Link Reversal
 *
 * Stats
 * Runtime: 128 ms, faster than 95.61%
 * Memory Usage: 33.8 MB, less than 39.47%
 */
private fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
    // Empty list or left equals right
    if (head == null || left == right) {
        return head
    }

    var updatedLeft = left
    var updatedRight = right
    var updatedHead = head

    // Move the two pointers until they reach the proper starting point in the list.
    var current = updatedHead
    var prev: ListNode? = null
    while (updatedLeft > 1) {
        prev = current
        current = current?.next
        updatedLeft--
        updatedRight--
    }

    // The two pointers that will fix the final connections.
    val con = prev
    val tail = current

    // Iteratively reverse the nodes until n becomes 0.
    var third: ListNode?
    while (updatedRight > 0) {
        third = current?.next
        current?.next = prev
        prev = current
        current = third
        updatedRight--
    }

    // Adjust the final connections as explained in the algorithm
    if (con != null) {
        con.next = prev
    } else {
        updatedHead = prev
    }
    tail?.next = current
    return updatedHead
}

private fun main() {

}

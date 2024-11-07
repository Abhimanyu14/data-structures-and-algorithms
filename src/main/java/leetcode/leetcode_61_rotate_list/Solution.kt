package leetcode.leetcode_61_rotate_list

import data_structures_and_algorithms.linkedlist.ListNode

/**
 * leetcode - https://leetcode.com/problems/rotate-list/
 *
 * Using linked list
 *
 * Stats
 * Runtime: 155 ms, faster than 84.46%
 * Memory Usage: 36.3 MB, less than 52.70%
 */
private fun rotateRight(head: ListNode?, k: Int): ListNode? {
    if (head?.next == null) {
        return head
    }
    var size = 0
    var current = head
    while (current != null) {
        size++
        current = current.next
    }
    if (k % size == 0) {
        return head
    }
    current = head
    repeat(size - (k % size) - 1) {
        current = current?.next
    }
    val newHead = current?.next
    current?.next = null
    current = newHead
    while (current?.next != null) {
        current = current?.next
    }
    current?.next = head
    return newHead
}

private fun main() {

}

package leetcode.leetcode_19_remove_nth_node_from_end_of_list

import data_structures_and_algorithms.linkedlist.ListNode

/**
 * leetcode - https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * Using dummy node
 *
 * Stats
 * Runtime: 137 ms, faster than 96.46%
 * Memory Usage: 34.7 MB, less than 51.38%
 */
private fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    val dummy = ListNode(-1)
    dummy.next = head
    var current: ListNode? = dummy
    var lookAhead: ListNode? = dummy
    repeat(n) {
        lookAhead = lookAhead?.next
    }
    while (lookAhead?.next != null) {
        lookAhead = lookAhead?.next
        current = current?.next
    }
    current?.next = current?.next?.next

    return dummy.next
}

/**
 * leetcode - https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * Using two pointer
 *
 * Stats
 * Runtime: 366 ms, faster than 5.11%
 * Memory Usage: 35.9 MB, less than 5.32%
 */
private fun removeNthFromEndUsingTwoPointer(head: ListNode?, n: Int): ListNode? {
    // Empty list
    if (head == null) {
        return head
    }

    // Removing first node from list with 1 node
    if (n == 1 && head.next == null) {
        return null
    }

    var prev: ListNode? = null
    var current: ListNode? = head
    var tail: ListNode? = head
    var count = n
    while (count > 0 && tail != null) {
        tail = tail.next
        count--
    }

    // List does not have enough items
    if (count != 0) {
        return head
    }

    // Remove first node
    if (tail == null) {
        return head.next
    }

    while (tail != null) {
        prev = current
        current = current?.next
        tail = tail.next
    }
    prev?.next = current?.next
    return head
}

private fun main() {

}

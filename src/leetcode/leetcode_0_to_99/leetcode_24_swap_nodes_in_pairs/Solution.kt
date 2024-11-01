package leetcode.leetcode_0_to_99.leetcode_24_swap_nodes_in_pairs

import data_structures_and_algorithms.linkedlist.ListNode

/**
 * leetcode - https://leetcode.com/problems/swap-nodes-in-pairs/
 *
 * Using recursion
 *
 * Stats
 * Runtime: 137 ms, faster than 70.92%
 * Memory Usage: 33.6 MB, less than 79.59%
 */
private fun swapPairs(head: ListNode?): ListNode? {
    var current: ListNode? = head
    val dummy = ListNode(-1)

    dummy.next = current
    var prev = dummy

    while (current?.next != null) {
        val first = current
        val second = current.next

        // Swapping
        prev.next = second
        first.next = second?.next
        second?.next = first

        // Reinitializing the head and prevNode for next swap
        prev = first
        current = first.next // jump
    }

    return dummy.next
}

/**
 * leetcode - https://leetcode.com/problems/swap-nodes-in-pairs/
 *
 * Using recursion
 *
 * Stats
 * Runtime: 145 ms, faster than 45.92%
 * Memory Usage: 34.2 MB, less than 16.84%
 */
private fun swapPairsUsingRecursion(head: ListNode?): ListNode? {
    if (head?.next == null) {
        return head
    }

    val first: ListNode = head
    val second = head.next

    first.next = swapPairsUsingRecursion(second?.next)
    second?.next = first

    return second
}

private fun main() {

}

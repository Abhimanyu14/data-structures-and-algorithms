package leetcode.leetcode_142_linked_list_cycle_ii

import data_structures.linkedlist.ListNode

/**
 * leetcode - https://leetcode.com/problems/linked-list-cycle-ii/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [Set]
 * Algorithm - Iteration and Hashing
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private fun detectCycle(head: ListNode?): ListNode? {
    if (head == null) {
        return null
    }
    val set = mutableSetOf<ListNode>()
    var current = head
    while (current != null) {
        if (set.contains(current)) {
            return current
        }
        set.add(current)
        current = current.next
    }
    return null
}

private fun main() {

}

package leetcode.leetcode_2100_to_2199.leetcode_2181_merge_nodes_in_between_zeros

import data_structures_and_algorithms.linkedlist.ListNode

/**
 * leetcode - https://leetcode.com/problems/merge-nodes-in-between-zeros/?envType=daily-question&envId=2024-07-04
 *
 * Using linked list
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 843 ms, faster than 72.22%
 * Memory Usage: 71.4 MB, less than 61.11%
 *
 * Time -
 * Space -
 */
private fun mergeNodes(head: ListNode?): ListNode? {
    if (head == null) {
        return null
    }
    var current = head.next
    while (current?.next != null) {
        if (current.next?.`val` == 0) {
            current.next = current.next?.next
            current = current.next
        } else {
            current.`val` += current.next?.`val` ?: 0
            current.next = current.next?.next
        }
    }
    return head.next
}

private fun main() {

}

package leetcode.leetcode_3217_delete_nodes_from_linked_list_present_in_array

import data_structures.linkedlist.ListNode

/**
 * leetcode - https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/?envType=daily-question&envId=2024-09-06
 *
 * Using Linked list
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 1057 ms, faster than 51.11%
 * Memory Usage: 75.5 MB, less than 86.67%
 *
 * Time -
 * Space -
 */
private fun modifiedList(nums: IntArray, head: ListNode?): ListNode? {
    val set = nums.toSet()
    val dummy = ListNode(-1).apply {
        next = head
    }
    var current = dummy
    var lookAhead = dummy.next
    while (lookAhead != null) {
        if (set.contains(lookAhead.`val`)) {
            current.next = lookAhead.next

        } else {
            current = lookAhead
        }
        lookAhead = lookAhead.next
    }
    return dummy.next
}

private fun main() {

}

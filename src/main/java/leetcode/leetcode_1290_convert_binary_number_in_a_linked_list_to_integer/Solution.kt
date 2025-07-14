package leetcode.leetcode_1290_convert_binary_number_in_a_linked_list_to_integer

import data_structures.linkedlist.ListNode

/**
 * leetcode - https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/description/?envType=daily-question&envId=2025-07-14
 *
 * Data Structure - Linked List
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Amazon, Google, Meta, Microsoft
 */
private fun getDecimalValue(head: ListNode?): Int {
    var result = 0
    var current = head
    while (current != null) {
        result = (result * 2) + (current.`val`)
        current = current.next
    }
    return result
}

private fun main() {

}

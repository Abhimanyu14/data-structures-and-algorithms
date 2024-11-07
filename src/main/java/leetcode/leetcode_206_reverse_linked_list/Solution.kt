package leetcode.leetcode_206_reverse_linked_list

import data_structures_and_algorithms.linkedlist.createLinkedList
import data_structures_and_algorithms.linkedlist.reverseList
import data_structures_and_algorithms.linkedlist.printLinkedList

/**
 * leetcode - https://leetcode.com/problems/reverse-linked-list/
 *
 * Stats
 * Runtime: 164 ms, faster than 69.33%
 * Memory Usage: 36.2 MB, less than 18.20%
 */
private fun main() {
    val input = intArrayOf(1, 2, 3, 4, 5)
    val listNode = createLinkedList(input)
    val result = reverseList(listNode)
    printLinkedList(result)
}

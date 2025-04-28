package leetcode.leetcode_237_delete_node_in_a_linked_ist

import data_structures.linkedlist.ListNode
import data_structures.linkedlist.createLinkedList
import data_structures.linkedlist.printLinkedList

/**
 * leetcode - https://leetcode.com/problems/delete-node-in-a-linked-list/
 *
 * Using linked list operations
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 167 ms, faster than 45.24%
 * Memory Usage: 36.6 MB, less than 36.90%
 *
 * Time - O(1)
 * Space - O(1)
 */
private fun deleteNode(node: ListNode?) {
    val nextNode = node?.next ?: return
    node.`val` = nextNode.`val`
    node.next = nextNode.next
}

private fun main() {
    val input1 = createLinkedList(intArrayOf(4, 5, 1, 9))
    val nodeToDelete1 = input1?.next

    val input2 = createLinkedList(intArrayOf(4, 5, 1, 9))
    val nodeToDelete2 = input2?.next?.next

    val input3 = createLinkedList(intArrayOf(1, 2, 3, 4))
    val nodeToDelete3 = input3?.next?.next

    val input4 = createLinkedList(intArrayOf(0, 1))
    val nodeToDelete4 = input4

    val input5 = createLinkedList(intArrayOf(-3, 5, -99))
    val nodeToDelete5 = input5

    deleteNode(nodeToDelete1)
    deleteNode(nodeToDelete2)
    deleteNode(nodeToDelete3)
    deleteNode(nodeToDelete4)
    deleteNode(nodeToDelete5)

    printLinkedList(input1)
    printLinkedList(input2)
    printLinkedList(input3)
    printLinkedList(input4)
    printLinkedList(input5)
}

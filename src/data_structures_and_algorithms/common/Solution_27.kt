package data_structures_and_algorithms.common

import data_structures_and_algorithms.linkedlist.ListNode

/**
 * Linked list traversal
 *
 * Using iteration
 */
private fun linkedListTraversal(root: ListNode, n: Int): Int {
    var current: ListNode? = root
    var count = 1
    while (count < n && current?.next != null) {
        count++
        current = current.next
    }
    return current?.`val` ?: 0
}

private fun main() {
}

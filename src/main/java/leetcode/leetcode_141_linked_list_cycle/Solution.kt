package leetcode.leetcode_141_linked_list_cycle

import data_structures.linkedlist.ListNode
import data_structures.linkedlist.createLinkedList
import data_structures.linkedlist.lastNode

/**
 * leetcode - https://leetcode.com/problems/linked-list-cycle/
 *
 * Using Floyd's Cycle Finding Algorithm
 *
 * Stats
 * Runtime: 188 ms, faster than 62.99%
 * Memory Usage: 36.9 MB, less than 33.45%
 */
private fun hasCycle(head: ListNode?): Boolean {
    if (head?.next == null) {
        return false
    }
    var slow = head
    var fast = head.next
    while (fast != null) {
        if (slow == fast) {
            return true
        }
        slow = slow?.next
        fast = fast.next?.next
    }
    return false
}

private fun main() {
    val input1 = intArrayOf(3, 2, 0, -4)
    val input2 = intArrayOf(1, 2)
    val input3 = intArrayOf(1)

    val listNode1 = createLinkedList(input1)
    lastNode(listNode1)?.next = listNode1?.next

    val listNode2 = createLinkedList(input2)
    lastNode(listNode2)?.next = listNode2

    val listNode3 = createLinkedList(input3)

    println(hasCycle(listNode1))
    println(hasCycle(listNode2))
    println(hasCycle(listNode3))
}

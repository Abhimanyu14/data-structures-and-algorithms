package leetcode.leetcode_0_to_99.leetcode_2_add_two_numbers

import data_structures_and_algorithms.linkedlist.ListNode
import data_structures_and_algorithms.linkedlist.createLinkedList
import data_structures_and_algorithms.linkedlist.printLinkedList

/**
 * leetcode - https://leetcode.com/problems/add-two-numbers/
 *
 * Stats
 * Runtime: 390 ms, faster than 71.44%
 * Memory Usage: 51.2 MB, less than 23.94%
 */
fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val result = ListNode((l1!!.`val`.plus(l2!!.`val`)).rem(10))
    var remainder: Int = (l1.`val`.plus(l2.`val`)).div(10)
    var resultNode = result
    var firstNode = l1
    var secondNode = l2
    while (firstNode?.next != null || secondNode?.next != null || remainder != 0) {
        firstNode = firstNode?.next
        secondNode = secondNode?.next
        resultNode.next = ListNode(((firstNode?.`val` ?: 0).plus(secondNode?.`val` ?: 0).plus(remainder)).rem(10))
        resultNode = resultNode.next!!
        remainder = ((firstNode?.`val` ?: 0).plus(secondNode?.`val` ?: 0).plus(remainder)).div(10)
    }
    return result
}

private fun main() {
    val input1 = intArrayOf(2, 4, 3)
    val input2 = intArrayOf(5, 6, 4)
    val listNode1 = createLinkedList(input1)
    val listNode2 = createLinkedList(input2)
    printLinkedList(addTwoNumbers(listNode1, listNode2))
}

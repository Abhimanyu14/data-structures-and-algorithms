package leetcode.leet_0_to_99.leet_2_add_two_numbers

import common.data_structures.ListNode
import common.data_structures.createLinkedList
import common.data_structures.printLinkedList

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

fun main() {
    val input1 = intArrayOf(2, 4, 3)
    val input2 = intArrayOf(5, 6, 4)
    val listNode1 = createLinkedList(input1)
    val listNode2 = createLinkedList(input2)
    printLinkedList(addTwoNumbers(listNode1, listNode2))
}

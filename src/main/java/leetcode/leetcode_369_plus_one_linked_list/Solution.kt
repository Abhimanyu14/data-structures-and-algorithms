package leetcode.leetcode_369_plus_one_linked_list

import data_structures_and_algorithms.linkedlist.ListNode
import data_structures_and_algorithms.linkedlist.createLinkedList
import data_structures_and_algorithms.linkedlist.printLinkedList

/**
 * leetcode - https://leetcode.com/problems/plus-one-linked-list/
 * Premium question
 *
 * Stats
 */
fun addWithCarry(head: ListNode?): Int {
    if (head == null) {
        return 1
    }
    val res = head.`val` + addWithCarry(head.next)
    head.`val` = res % 10
    return res / 10
}

fun addOne(head: ListNode?): ListNode? {
    val carry = addWithCarry(head)
    if (carry > 0) {
        val newHead = ListNode(carry)
        newHead.next = head
        return newHead
    }
    return head
}

private fun main() {
    val input1 = intArrayOf(1, 9, 9)
    val input2 = intArrayOf(9, 9, 9)
    val listNode1 = createLinkedList(input1)
    val listNode2 = createLinkedList(input2)
    printLinkedList(addOne(listNode1))
    printLinkedList(addOne(listNode2))
}

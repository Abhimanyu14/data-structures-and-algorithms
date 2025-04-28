package leetcode.leetcode_2_add_two_numbers

import data_structures.linkedlist.ListNode
import data_structures.linkedlist.createLinkedList
import data_structures.linkedlist.printLinkedList

/**
 * leetcode - https://leetcode.com/problems/add-two-numbers/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 1 ms, faster than 100.00%
 * Memory Usage: 45.94 MB, less than 48.24%
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Google, Meta
 */
private fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null) {
        return l2
    }
    if (l2 == null) {
        return l1
    }
    var sum = l1.`val` + l2.`val`
    var carry = sum / 10
    val result = ListNode(sum % 10)
    var pointer1: ListNode? = l1.next
    var pointer2: ListNode? = l2.next
    var current = result
    while (pointer1 != null || pointer2 != null) {
        sum = (pointer1?.`val` ?: 0) + (pointer2?.`val` ?: 0) + carry
        carry = sum / 10

        val next = ListNode(sum % 10)

        current.next = next
        current = next

        pointer1 = pointer1?.next
        pointer2 = pointer2?.next
    }
    if (carry > 0) {
        val next = ListNode(carry)
        current.next = next
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

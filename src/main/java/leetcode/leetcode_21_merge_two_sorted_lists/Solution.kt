package leetcode.leetcode_21_merge_two_sorted_lists

import data_structures.linkedlist.ListNode
import data_structures.linkedlist.createLinkedList
import data_structures.linkedlist.printLinkedList

/**
 * leetcode - https://leetcode.com/problems/merge-two-sorted-lists/
 * https://leetcode.com/problems/merge-two-sorted-lists/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Data Structure - Linked List
 * Algorithm - Two Pointers
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 42.58 MB, less than 40.58%
 *
 * Time - O(M + N)
 * Space - O(M + N)
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null) {
        return list2
    }
    if (list2 == null) {
        return list1
    }
    val dummy = ListNode(-1)
    var current: ListNode? = dummy
    var p1 = list1
    var p2 = list2
    while (p1 != null && p2 != null) {
        if (p1.`val` <= p2.`val`) {
            current?.next = p1
            p1 = p1.next
        } else {
            current?.next = p2
            p2 = p2.next
        }
        current = current?.next
    }
    if (p1 == null) {
        current?.next = p2
    }
    if (p2 == null) {
        current?.next = p1
    }
    return dummy.next
}

private fun main() {
    val input1 = intArrayOf(1, 2, 4)
    val input2 = intArrayOf(1, 3, 4)
    val listNode1 = createLinkedList(input1)
    val listNode2 = createLinkedList(input2)
    val result = mergeTwoLists(listNode1, listNode2)
    printLinkedList(result)
}

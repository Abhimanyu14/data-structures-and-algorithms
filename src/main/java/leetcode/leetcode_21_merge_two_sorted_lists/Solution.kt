package leetcode.leetcode_21_merge_two_sorted_lists

import data_structures_and_algorithms.linkedlist.ListNode
import data_structures_and_algorithms.linkedlist.createLinkedList
import data_structures_and_algorithms.linkedlist.printLinkedList

/**
 * leetcode - https://leetcode.com/problems/merge-two-sorted-lists/
 * https://leetcode.com/problems/merge-two-sorted-lists/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Data Structure - [LinkedList]
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
 * Companies - Google, Meta
 */
private fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null) {
        return list2
    }
    if (list2 == null) {
        return list1
    }
    var pointer1: ListNode? = list1
    var pointer2: ListNode? = list2
    fun getNextNode(): ListNode? {
        return if ((pointer1?.`val` ?: 0) <= (pointer2?.`val` ?: 0)) {
            pointer1.also {
                pointer1 = pointer1?.next
            }
        } else {
            pointer2.also {
                pointer2 = pointer2?.next
            }
        }
    }

    val root = getNextNode()
    var current: ListNode? = root
    while (pointer1 != null && pointer2 != null) {
        current?.next = getNextNode()
        current = current?.next
    }
    if (pointer1 != null) {
        current?.next = pointer1
    }
    if (pointer2 != null) {
        current?.next = pointer2
    }
    return root
}

/**
 * leetcode - https://leetcode.com/problems/merge-two-sorted-lists/
 * https://leetcode.com/problems/merge-two-sorted-lists/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Data Structure - [LinkedList]
 * Algorithm - Two Pointers
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 1 ms, faster than 33.80%
 * Memory Usage: 43.29 MB, less than 9.17%
 *
 * Time - O(M + N)
 * Space - O(M + N)
 *
 * Companies - Google, Meta
 */
private fun mergeTwoListsWithNewNodes(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null) {
        return list2
    }
    if (list2 == null) {
        return list1
    }
    var pointer1: ListNode? = list1
    var pointer2: ListNode? = list2
    val root = if ((pointer1?.`val` ?: 0) <= (pointer2?.`val` ?: 0)) {
        ListNode((pointer1?.`val` ?: 0)).also {
            pointer1 = pointer1?.next
        }
    } else {
        ListNode((pointer2?.`val` ?: 0)).also {
            pointer2 = pointer2?.next
        }
    }
    var current: ListNode? = root
    while (pointer1 != null && pointer2 != null) {
        val next = if ((pointer1?.`val` ?: 0) <= (pointer2?.`val` ?: 0)) {
            ListNode((pointer1?.`val` ?: 0)).also {
                pointer1 = pointer1?.next
            }
        } else {
            ListNode((pointer2?.`val` ?: 0)).also {
                pointer2 = pointer2?.next
            }
        }
        current?.next = next
        current = next
    }
    while (pointer1 != null) {
        val next = ListNode((pointer1?.`val` ?: 0))
        pointer1 = pointer1?.next
        current?.next = next
        current = next
    }
    while (pointer2 != null) {
        val next = ListNode((pointer2?.`val` ?: 0))
        pointer2 = pointer2?.next
        current?.next = next
        current = next
    }
    return root
}

private fun main() {
    val input1 = intArrayOf(1, 2, 4)
    val input2 = intArrayOf(1, 3, 4)
    val listNode1 = createLinkedList(input1)
    val listNode2 = createLinkedList(input2)
    val result = mergeTwoLists(listNode1, listNode2)
    printLinkedList(result)
}

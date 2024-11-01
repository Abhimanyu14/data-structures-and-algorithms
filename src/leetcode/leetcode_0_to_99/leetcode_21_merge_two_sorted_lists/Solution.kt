package leetcode.leetcode_0_to_99.leetcode_21_merge_two_sorted_lists

import data_structures_and_algorithms.linkedlist.ListNode
import data_structures_and_algorithms.linkedlist.createLinkedList
import data_structures_and_algorithms.linkedlist.printLinkedList

/**
 * leetcode - https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * Using loops
 *
 * Stats
 * Runtime: 172 ms, faster than 51.81%
 * Memory Usage: 35.3 MB, less than 28.51%
 */
fun mergeTwoListsBruteForce(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null) {
        return l2
    }
    if (l2 == null) {
        return l1
    }
    var l1Pointer = l1
    var l2Pointer = l2
    var temp: Int
    val result = if (l1Pointer.`val` <= l2Pointer.`val`) {
        temp = l1Pointer.`val`
        l1Pointer = l1Pointer.next
        ListNode(temp)
    } else {
        temp = l2Pointer.`val`
        l2Pointer = l2Pointer.next
        ListNode(temp)
    }

    var resultPointer = result
    while (l1Pointer != null || l2Pointer != null) {
        if (l1Pointer == null) {
            temp = l2Pointer!!.`val`
            l2Pointer = l2Pointer.next
            resultPointer.next = ListNode(temp)
            resultPointer = resultPointer.next!!
        } else if (l2Pointer == null) {
            temp = l1Pointer.`val`
            l1Pointer = l1Pointer.next
            resultPointer.next = ListNode(temp)
            resultPointer = resultPointer.next!!
        } else {
            if (l1Pointer.`val` <= l2Pointer.`val`) {
                temp = l1Pointer.`val`
                l1Pointer = l1Pointer.next
                resultPointer.next = ListNode(temp)
                resultPointer = resultPointer.next!!
            } else {
                temp = l2Pointer.`val`
                l2Pointer = l2Pointer.next
                resultPointer.next = ListNode(temp)
                resultPointer = resultPointer.next!!
            }
        }
    }
    return result
}

/**
 * Using loops
 *
 * Stats
 * Runtime: 307 ms, faster than 45.93%
 * Memory Usage: 36 MB, less than 53.04%
 */
fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null) {
        return l2
    }
    if (l2 == null) {
        return l1
    }
    var p1 = l1
    var p2 = l2
    val resultHead = if (p1.`val` <= p2.`val`) {
        ListNode(p1.`val`).also {
            p1 = p1?.next
        }
    } else {
        ListNode(p2.`val`).also {
            p2 = p2?.next
        }
    }
    var resultPointer = resultHead
    while (p1 != null && p2 != null) {
        if ((p1?.`val` ?: 0) <= (p2?.`val` ?: 0)) {
            resultPointer.next = ListNode(p1?.`val` ?: 0)
            resultPointer = resultPointer.next!!
            p1 = p1?.next
        } else {
            resultPointer.next = ListNode(p2?.`val` ?: 0)
            resultPointer = resultPointer.next!!
            p2 = p2?.next
        }
    }
    if (p1 != null) {
        resultPointer.next = p1
    } else {
        resultPointer.next = p2
    }
    return resultHead
}

private fun main() {
    val input1 = intArrayOf(1, 2, 4)
    val input2 = intArrayOf(1, 3, 4)
    val listNode1 = createLinkedList(input1)
    val listNode2 = createLinkedList(input2)
    val result = mergeTwoLists(listNode1, listNode2)
    printLinkedList(result)
}

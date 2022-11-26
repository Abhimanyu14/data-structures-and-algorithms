package leetcode.leet_0_to_99.leet_21_merge_two_sorted_lists

import common.data_structures.ListNode
import common.data_structures.createLinkedList
import common.data_structures.printLinkedList

/**
 * Stats
 * Runtime: 172 ms, faster than 51.81%
 * Memory Usage: 35.3 MB, less than 28.51%
 */
fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
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

fun main() {
    val input1 = intArrayOf(1, 2, 4)
    val input2 = intArrayOf(1, 3, 4)
    val listNode1 = createLinkedList(input1)
    val listNode2 = createLinkedList(input2)
    val result = mergeTwoLists(listNode1, listNode2)
    printLinkedList(result)
}

package leetcode.leet_200_to_299.leet_203_remove_linked_list_elements

import common.data_structures.ListNode
import common.data_structures.createLinkedList
import common.data_structures.printLinkedList

/**
 * Stats
 * Runtime: 204 ms, faster than 67.29%
 * Memory Usage: 37.7 MB, less than 53.27%
 */
fun removeElements(head: ListNode?, `val`: Int): ListNode? {
    var result = head
    while (result?.`val` == `val`) {
        result = result.next
    }
    if (result != null) {
        var headPointer = result
        while (headPointer != null) {
            if (headPointer.next?.`val` == `val`) {
                headPointer.next = headPointer.next?.next
            } else {
                headPointer = headPointer.next
            }
        }
    }
    return result
}

fun main() {
    val input1 = createLinkedList(intArrayOf(1, 2, 6, 3, 4, 5, 6))
    val input2 = createLinkedList(intArrayOf())
    val input3 = createLinkedList(intArrayOf(7, 7, 7, 7))
    val input4 = createLinkedList(intArrayOf(1, 2, 2, 1))
    printLinkedList(removeElements(input1, 6))
    printLinkedList(removeElements(input2, 1))
    printLinkedList(removeElements(input3, 7))
    printLinkedList(removeElements(input4, 2))
}

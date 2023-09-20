package leetcode.leet_0_to_99.leet_86_partition_list

import data_structures_and_algorithms.linkedlist.ListNode

/**
 * leetcode - https://leetcode.com/problems/partition-list/
 *
 * Using pointers
 *
 * Stats
 * Runtime: 147 ms, faster than 94.12%
 * Memory Usage: 34.5 MB, less than 86.27%
 */
private fun partition(head: ListNode?, x: Int): ListNode? {
    if (head?.next == null) {
        return head
    }

    var lessHead: ListNode? = null
    var lessTail: ListNode? = null

    var equalOrMoreHead: ListNode? = null
    var equalOrMoreTail: ListNode? = null

    var current: ListNode? = head

    while (current != null) {
        if (current.`val` < x) {
            if (lessHead == null) {
                lessHead = current
                lessTail = current
            } else {
                lessTail?.next = current
                lessTail = lessTail?.next
            }
        } else {
            if (equalOrMoreHead == null) {
                equalOrMoreHead = current
                equalOrMoreTail = current
            } else {
                equalOrMoreTail?.next = current
                equalOrMoreTail = equalOrMoreTail?.next
            }
        }
        current = current.next
    }
    equalOrMoreTail?.next = null
    if (lessHead == null) {
        return equalOrMoreHead
    }
    lessTail?.next = equalOrMoreHead
    return lessHead
}

private fun main() {

}

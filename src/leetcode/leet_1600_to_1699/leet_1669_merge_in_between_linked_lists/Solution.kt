package leetcode.leet_1600_to_1699.leet_1669_merge_in_between_linked_lists

import data_structures_and_algorithms.linkedlist.ListNode

/**
 * leetcode - https://leetcode.com/problems/merge-in-between-linked-lists/
 *
 * Using iteration
 *
 * Stats
 * Runtime: 457 ms, faster than 100.00%
 * Memory Usage: 41 MB, less than 100.00%
 */
private fun mergeInBetween(list1: ListNode?, a: Int, b: Int, list2: ListNode?): ListNode? {
    var list2Tail = list2
    while (list2Tail?.next != null) {
        list2Tail = list2Tail?.next
    }

    var current = list1
    repeat(a - 1) {
        current = current?.next
    }
    var temp = current?.next
    current?.next = list2

    repeat(b - a) {
        temp = temp?.next
    }
    list2Tail?.next = temp?.next

    return list1
}

/**
 * leetcode - https://leetcode.com/problems/merge-in-between-linked-lists/
 *
 * Using iteration
 *
 * Stats
 * Runtime: 435 ms, faster than 100.00%
 * Memory Usage: 42.8 MB, less than 33.33%
 */
private fun mergeInBetweenUsingDummy(list1: ListNode?, a: Int, b: Int, list2: ListNode?): ListNode? {
    val dummy = ListNode(-1).apply {
        next = list1
    }
    var prev: ListNode? = dummy
    var current: ListNode? = list1
    repeat(a) {
        prev = current
        current = current?.next
    }
    prev?.next = list2
    var list2Tail: ListNode? = list2
    while (list2Tail?.next != null) {
        list2Tail = list2Tail.next
    }
    repeat(b - a) {
        current = current?.next
    }
    list2Tail?.next = current?.next
    return dummy.next
}

private fun main() {

}

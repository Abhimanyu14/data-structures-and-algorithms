package leetcode.leetcode_100_to_199.leetcode_147_insertion_sort_list

import data_structures_and_algorithms.linkedlist.ListNode

/**
 * leetcode - https://leetcode.com/problems/insertion-sort-list/
 *
 * Using linked list
 *
 * Stats
 * Runtime: 193 ms, faster than 77.14%
 * Memory Usage: 37.8 MB, less than 20.00%
 */
private fun insertionSortList(head: ListNode?): ListNode? {
    if (head?.next == null) {
        return head
    }
    var newHead = head
    var newTail = head
    var temp: ListNode?
    var current: ListNode?
    while (newTail?.next != null) {
        if ((newTail.next?.`val` ?: 0) >= (newTail.`val` ?: 0)) {
            newTail = newTail.next
            continue
        }
        temp = newTail.next
        newTail.next = newTail.next?.next
        if ((temp?.`val` ?: 0) <= (newHead?.`val` ?: 0)) {
            temp?.next = newHead
            newHead = temp
            continue
        }
        current = newHead
        while ((current?.next?.`val` ?: 0) < (temp?.`val` ?: 0)) {
            current = current?.next
        }
        temp?.next = current?.next
        current?.next = temp
    }
    return newHead
}

private fun main() {

}

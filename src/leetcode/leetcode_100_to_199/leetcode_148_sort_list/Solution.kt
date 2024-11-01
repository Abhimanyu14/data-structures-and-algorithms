package leetcode.leetcode_100_to_199.leetcode_148_sort_list

import data_structures_and_algorithms.linkedlist.ListNode

/**
 * leetcode - https://leetcode.com/problems/sort-list/
 *
 * Using insertion sort
 *
 * Stats
 * Runtime: 2189 ms, faster than 5.31%
 * Memory Usage: 50.1 MB, less than 36.28%
 */
private fun sortList(head: ListNode?): ListNode? {
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

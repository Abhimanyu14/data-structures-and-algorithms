package leetcode.leetcode_876_middle_of_the_linked_list

import data_structures.linkedlist.ListNode

/**
 * leetcode - https://leetcode.com/problems/middle-of-the-linked-list/description/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Linked List
 * Algorithm - Two Pointer
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Google
 */
private fun middleNode(head: ListNode?): ListNode? {
    if (head == null) {
        return null
    }
    var middle: ListNode? = head
    var last: ListNode? = head
    while (last?.next != null) {
        middle = middle?.next
        last = last.next?.next
    }
    return middle
}

/**
 * leetcode - https://leetcode.com/problems/middle-of-the-linked-list/?envType=daily-question&envId=2024-03-07
 *
 * Using list size
 *
 * Stats
 * Runtime: 252 ms, faster than 43.36%
 * Memory Usage: 34.2 MB, less than 43.65%
 */
private fun middleNodeNaive(head: ListNode?): ListNode? {
    var count = 0
    var result = head
    // count list size
    while (result != null) {
        count++
        result = result.next
    }

    // reset values
    count /= 2
    result = head

    // traverse till middle
    while (count != 0) {
        result = result?.next
        count--
    }
    return result
}

private fun main() {

}

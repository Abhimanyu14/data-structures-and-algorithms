package leetcode.leet_800_to_899.leet_876_middle_of_the_linked_list

import data_structures_and_algorithms.linkedlist.ListNode

/**
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

/**
 * Using two pointer
 *
 * Stats
 * Runtime: 255 ms, faster than 39.80%
 * Memory Usage: 33.9 MB, less than 79.89%
 */
private fun middleNode(head: ListNode?): ListNode? {
    var fast = head
    var slow = head
    while (fast?.next != null) {
        fast = fast.next?.next
        slow = slow?.next
    }
    return slow
}

private fun main() {

}

package leetcode.leetcode_876_middle_of_the_linked_list

import data_structures_and_algorithms.linkedlist.ListNode


/**
 * leetcode - https://leetcode.com/problems/middle-of-the-linked-list/?envType=daily-question&envId=2024-03-07
 *
 * Using two pointer
 *
 * Stats
 * Runtime: 134 ms, faster than 74.55%
 * Memory Usage: 33.8 MB, less than 61.58%
 */
private fun middleNode(head: ListNode?): ListNode? {
    var slow = head
    var fast = head
    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }
    return slow
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

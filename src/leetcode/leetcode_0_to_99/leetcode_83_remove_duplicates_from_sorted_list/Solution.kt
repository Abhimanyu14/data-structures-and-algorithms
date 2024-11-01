package leetcode.leetcode_0_to_99.leetcode_83_remove_duplicates_from_sorted_list

import data_structures_and_algorithms.linkedlist.ListNode

/**
 * leetcode - https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 *
 * Using two pointer
 *
 * Stats
 * Runtime: 354 ms, faster than 24.02%
 * Memory Usage: 39.1 MB, less than 27.51%
 */
private fun deleteDuplicatesUsingTwoPointer(head: ListNode?): ListNode? {
    var pointer = head
    var next = head?.next
    while (next != null) {
        if (pointer?.`val` == next?.`val`) {
            pointer?.next = next?.next
        } else {
            pointer = pointer?.next
        }
        next = next?.next
    }
    return head
}

/**
 * Using single pointer
 *
 * Stats
 * Runtime: 251 ms, faster than 83.41%
 * Memory Usage: 36.7 MB, less than 87.34%
 */
private fun deleteDuplicates(head: ListNode?): ListNode? {
    var pointer = head
    while (pointer?.next != null) {
        if (pointer.`val` == pointer.next?.`val`) {
            pointer.next = pointer.next?.next
        } else {
            pointer = pointer.next
        }
    }
    return head
}

private fun main() {

}

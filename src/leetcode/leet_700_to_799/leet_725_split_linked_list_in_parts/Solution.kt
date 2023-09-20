package leetcode.leet_700_to_799.leet_725_split_linked_list_in_parts

import data_structures_and_algorithms.linkedlist.ListNode

/**
 * leetcode - https://leetcode.com/problems/split-linked-list-in-parts/
 *
 * Using iteration
 *
 * Stats
 * Runtime: 164 ms, faster than 92.86%
 * Memory Usage: 36.8 MB, less than 57.14%
 */
private fun splitListToParts(head: ListNode?, k: Int): Array<ListNode?> {
    val result = arrayOfNulls<ListNode?>(k)
    var size = 0
    var temp: ListNode? = head
    while (temp != null) {
        size++
        temp = temp.next
    }
    val defaultSize = size / k
    var extra = size % k
    var prev: ListNode? = null
    temp = head
    for (i in 0 until k) {
        if (temp == null) {
            break
        }
        result[i] = temp
        size = if (extra == 0) {
            defaultSize
        } else {
            extra--
            defaultSize + 1
        }
        repeat(size) {
            prev = temp
            temp = temp?.next
        }
        prev?.next = null
    }
    return result
}

private fun main() {

}

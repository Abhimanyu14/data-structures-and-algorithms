package leetcode.leetcode_1171_remove_zero_sum_consecutive_nodes_from_linked_list

import data_structures.linkedlist.ListNode

/**
 * leetcode - https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
 *
 * TODO-Abhi: To revisit
 *
 * Solution - https://youtu.be/tss5biw6ctI?t=755
 *
 * Stats
 * Runtime: 163 ms, faster than 80.00%
 * Memory Usage: 37.2 MB, less than 100.00%
 */
private fun removeZeroSumSublists(head: ListNode?): ListNode? {
    val map = mutableMapOf<Int, ListNode>()
    var prefixSum = 0
    val dummy = ListNode(0).apply {
        next = head
    }
    map[0] = dummy
    var current = head
    while (current != null) {
        prefixSum += current.`val`
        if (map.contains(prefixSum)) {
            // Remove previous entries from map
            var nodeToRemove = map[prefixSum]?.next
            var removeKey = prefixSum
            while (nodeToRemove != current) {
                removeKey += nodeToRemove?.`val` ?: 0
                map.remove(removeKey)
                nodeToRemove = nodeToRemove?.next
            }

            // Delete nodes in between
            map[prefixSum]?.next = current.next
        } else {
            map[prefixSum] = current
        }
        current = current.next
    }
    return dummy.next
}

private fun main() {

}

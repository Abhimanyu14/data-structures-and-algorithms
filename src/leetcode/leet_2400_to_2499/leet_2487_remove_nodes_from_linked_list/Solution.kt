package leetcode.leet_2400_to_2499.leet_2487_remove_nodes_from_linked_list

import data_structures_and_algorithms.linkedlist.ListNode
import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/remove-nodes-from-linked-list/?envType=daily-question&envId=2024-05-06
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 744 ms, faster than 40.98%
 * Memory Usage: 55.1 MB, less than 100.00%
 *
 * Time -
 * Space -
 */
private fun removeNodes(head: ListNode?): ListNode? {
    fun reverseList(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var current: ListNode? = head
        var nextTemp: ListNode?

        // Set each node's next pointer to the previous node
        while (current != null) {
            nextTemp = current?.next
            current?.next = prev
            prev = current
            current = nextTemp
        }

        return prev
    }

    // Reverse the original linked list
    val root: ListNode? = reverseList(head)
    var maximum = 0
    var prev: ListNode? = null
    var current: ListNode? = root

    // Traverse the list deleting nodes
    while (current != null) {
        maximum = max(maximum, current?.`val` ?: 0)

        // Delete nodes that are smaller than maximum
        if ((current?.`val` ?: 0) < maximum) {
            // Delete current by skipping
            prev?.next = current?.next
            val deleted: ListNode? = current
            current = current?.next
            deleted?.next = null
        } else {
            prev = current
            current = current?.next
        }
    }

    // Reverse and return the modified linked list
    return reverseList(root)
}

private fun main() {

}

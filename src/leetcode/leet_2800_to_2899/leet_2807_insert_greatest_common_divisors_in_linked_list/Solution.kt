package leetcode.leet_2800_to_2899.leet_2807_insert_greatest_common_divisors_in_linked_list

import data_structures_and_algorithms.linkedlist.ListNode

/**
 * leetcode - https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun insertGreatestCommonDivisors(head: ListNode): ListNode {
    // If the list contains only one node, return the head as no insertion is needed
    if (head.next == null) {
        return head
    }

    // Helper method to calculate the greatest common divisor using the Euclidean algorithm
    fun calculateGCD(a: Int, b: Int): Int {
        var a1 = a
        var b1 = b
        while (b1 != 0) {
            val temp = b1
            b1 = a1 % b1
            a1 = temp
        }
        return a1
    }

    // Initialize pointers to traverse the list
    var node1: ListNode = head
    var node2: ListNode? = head.next

    // Traverse the linked list
    while (node2 != null) {
        val gcdValue = calculateGCD(node1.`val`, node2.`val`)
        val gcdNode = ListNode(gcdValue)

        // Insert the GCD node between node1 and node2
        node1.next = gcdNode
        gcdNode.next = node2

        // Move to the next pair of nodes
        node1 = node2
        node2 = node2.next
    }

    return head
}

private fun main() {

}

package leetcode.leetcode_1019_next_greater_node_in_linked_list

import data_structures.linkedlist.ListNode

/**
 * leetcode - https://leetcode.com/problems/next-greater-node-in-linked-list/?envType=problem-list-v2&envId=monotonic-stack
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Linked List, [ArrayDeque] (Monotonic Stack)
 * Algorithm - Monotonic Stack
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Amazon, Google, Microsoft
 */
private fun nextLargerNodes(head: ListNode?): IntArray {
    if (head == null) {
        return intArrayOf()
    }
    val result = mutableListOf<Int>()
    val stack = ArrayDeque<Pair<Int, Int>>()
    var index = 0
    var current: ListNode? = head
    while (current != null) {
        result.add(0)
        while (stack.isNotEmpty() && stack.last().first < current.`val`) {
            result[stack.removeLast().second] = current.`val`
        }
        stack.addLast(Pair(current.`val`, index))
        index++
        current = current.next
    }
    return result.toIntArray()
}

/**
 * leetcode - https://leetcode.com/problems/next-greater-node-in-linked-list/?envType=problem-list-v2&envId=monotonic-stack
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Linked List, [ArrayDeque] (Monotonic Stack)
 * Algorithm - Monotonic Stack
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Amazon, Google, Microsoft
 */
private fun nextLargerNodesUsingTwoPass(head: ListNode?): IntArray {
    if (head == null) {
        return intArrayOf()
    }
    var index = 0
    var current: ListNode? = head
    while (current != null) {
        index++
        current = current.next
    }
    val result = IntArray(index)
    val stack = ArrayDeque<Pair<Int, Int>>()
    current = head
    index = 0
    while (current != null) {
        while (stack.isNotEmpty() && stack.last().first < current.`val`) {
            result[stack.removeLast().second] = current.`val`
        }
        stack.addLast(Pair(current.`val`, index))
        index++
        current = current.next
    }
    return result
}

private fun main() {

}

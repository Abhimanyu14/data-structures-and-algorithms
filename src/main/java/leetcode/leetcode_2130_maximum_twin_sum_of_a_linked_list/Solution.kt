package leetcode.leetcode_2130_maximum_twin_sum_of_a_linked_list

import data_structures.linkedlist.ListNode
import java.util.Stack
import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
 *
 * Data Structure - LinkedList and Stack
 * Algorithm - Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 16 ms, faster than 47.55%
 * Memory Usage: 63.2 MB, less than 18.88%
 *
 * Time - O(N)
 * Space - O(N)
 */
private fun pairSum(head: ListNode?): Int {
    if (head == null) {
        return 0
    }
    var result = 0
    val stack = Stack<ListNode>()
    var size = 0
    var current: ListNode? = head
    while (current != null) {
        stack.push(current)
        current = current.next
        size++
    }
    current = head
    for (i in 0..<(size / 2)) {
        val popped = stack.pop()
        result = max(result, (current?.`val` ?: 0) + popped.`val`)
        current = current?.next
    }
    return result
}

private fun main() {

}

package leetcode.leetcode_2058_find_the_minimum_and_maximum_number_of_nodes_between_critical_points

import data_structures_and_algorithms.linkedlist.ListNode
import kotlin.math.abs
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/?envType=daily-question&envId=2024-07-05
 *
 * Using Linked list
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 507 ms, faster than 75.00%
 * Memory Usage: 67.5 MB, less than 25.00%
 *
 * Time -
 * Space -
 */
private fun nodesBetweenCriticalPoints(head: ListNode?): IntArray {
    var minDistance = -1
    var previous: ListNode = head ?: return intArrayOf(minDistance, -1)
    var current: ListNode = head.next ?: return intArrayOf(minDistance, -1)
    var lookAhead: ListNode = current.next ?: return intArrayOf(minDistance, -1)
    val criticalPoints = mutableListOf<Int>()
    var position = 1
    while (true) {
        if ((current.`val` > previous.`val` && current.`val` > lookAhead.`val`) || (current.`val` < previous.`val` && current.`val` < lookAhead.`val`)) {
            criticalPoints.add(position)
        }
        previous = current
        current = lookAhead
        if (lookAhead.next == null) {
            break
        }
        lookAhead.next?.let {
            lookAhead = it
        }
        position++
    }
    if (criticalPoints.size <= 1) {
        return intArrayOf(minDistance, -1)
    }
    minDistance = Int.MAX_VALUE
    for (i in 1..criticalPoints.lastIndex) {
        minDistance = min(minDistance, abs(criticalPoints[i] - criticalPoints[i - 1]))
    }
    return intArrayOf(minDistance, criticalPoints.last() - criticalPoints.first())
}

private fun main() {

}

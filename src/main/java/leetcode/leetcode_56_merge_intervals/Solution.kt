package leetcode.leetcode_56_merge_intervals

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/merge-intervals/
 *
 * Using intervals, [sortedBy]
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 34 ms, faster than 48.70%
 * Memory Usage: 44.5 MB, less than 53.04%
 *
 * Time -
 * Space -
 */
private fun merge(intervals: Array<IntArray>): Array<IntArray> {
    val result = mutableListOf<IntArray>()
    val sorted = intervals.sortedBy { it[0] }
    var current = sorted[0]
    var i = 0
    while (i <= sorted.lastIndex) {
        if (sorted[i][0] <= current[1]) {
            current[1] = max(current[1], sorted[i][1])
        } else {
            result.add(current)
            current = sorted[i]
        }
        i++
    }
    result.add(current)
    return result.toTypedArray()
}

private fun main() {

}

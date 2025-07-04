package leetcode.leetcode_56_merge_intervals

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/merge-intervals/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Data Structure - [List], [IntArray]
 * Algorithm - Sorting, Intervals & Iteration
 *
 * Using intervals, [sortedBy], [toTypedArray]
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 29 ms, faster than 50.57%
 * Memory Usage: 53.36 MB, less than 45.07%
 *
 * Time -
 * Space -
 *
 * Companies - Google, Meta
 */
private fun merge(intervals: Array<IntArray>): Array<IntArray> {
    val result = mutableListOf<IntArray>()
    val sortedIntervals = intervals.sortedBy { it[0] }
    var currentInterval = sortedIntervals[0]
    for (i in 1..sortedIntervals.lastIndex) {
        if (sortedIntervals[i][0] <= currentInterval[1]) {
            currentInterval = intArrayOf(currentInterval[0], max(currentInterval[1], sortedIntervals[i][1]))
        } else {
            result.add(currentInterval)
            currentInterval = sortedIntervals[i]
        }
    }
    result.add(currentInterval)
    return result.toTypedArray()
}

private fun main() {

}

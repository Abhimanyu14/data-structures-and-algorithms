package leetcode.leetcode_435_non_overlapping_intervals

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/non-overlapping-intervals/
 *
 * Interval problem
 *
 * Using sorting, greedy
 *
 * Solution - https://youtu.be/nONCGxWoUfM?si=aW28LQqbxeS1FFoJ
 *
 * Stats
 * Runtime: 731 ms, faster than 65.12%
 * Memory Usage: 104.9 MB, less than 17.44%
 */
private fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
    // Sort by starting value
    intervals.sortBy {
        it[0]
    }

    var result = 0
    var previousEnd = intervals[0][1]

    // Iterate from second element
    for (i in 1..intervals.lastIndex) {

        // Compare if start value is greater than or equal to previous end
        if (intervals[i][0] >= previousEnd) {
            // Update previous end
            previousEnd = intervals[i][1]
        } else {
            result++

            // Update previous end as minimum of previous end and current interval end
            previousEnd = min(previousEnd, intervals[i][1])
        }
    }

     return result
}

private fun main() {

}

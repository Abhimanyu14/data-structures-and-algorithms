package leetcode.leet_2400_to_2499.leet_2406_divide_intervals_into_minimum_number_of_groups

import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty -
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time -
 * Space -
 */
private fun minGroups(intervals: Array<IntArray>): Int {
    // Find the minimum and maximum value in the intervals
    var rangeStart = Int.MAX_VALUE
    var rangeEnd = Int.MIN_VALUE
    for (interval in intervals) {
        rangeStart = min(rangeStart.toDouble(), interval[0].toDouble()).toInt()
        rangeEnd = max(rangeEnd.toDouble(), interval[1].toDouble()).toInt()
    }

    // Initialize the array with all zeroes
    val pointToCount = IntArray(rangeEnd + 2)
    for (interval in intervals) {
        pointToCount[interval[0]]++ // Increment at the start of the interval
        pointToCount[interval[1] + 1]-- // Decrement right after the end of the interval
    }

    var concurrentIntervals = 0
    var maxConcurrentIntervals = 0
    for (i in rangeStart..rangeEnd) {
        // Update currently active intervals
        concurrentIntervals += pointToCount[i]
        maxConcurrentIntervals = max(
            maxConcurrentIntervals.toDouble(),
            concurrentIntervals.toDouble()
        ).toInt()
    }

    return maxConcurrentIntervals
}

/**
 * leetcode - https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty -
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time -
 * Space -
 */
private fun minGroupsUsingBruteForce(intervals: Array<IntArray>): Int {
    intervals.sortBy { interval ->
        interval[0]
    }
    val endTimes = mutableListOf<Int>()
    intervals.forEach { interval ->
        var added = false
        for (i in endTimes.indices) {
            if (endTimes[i] < interval[0]) {
                endTimes[i] = interval[1]
                added = true
                break
            }
        }
        if (!added) {
            endTimes.add(interval[1])
        }
    }
    return endTimes.size
}

private fun main() {

}

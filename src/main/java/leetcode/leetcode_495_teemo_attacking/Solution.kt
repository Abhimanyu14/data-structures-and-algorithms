package leetcode.leetcode_495_teemo_attacking

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/teemo-attacking/
 *
 * Using iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 20 ms, faster than 25.00%
 * Memory Usage: 40.6 MB, less than 40.00%
 *
 * Time -
 * Space -
 */
private fun findPoisonedDuration(timeSeries: IntArray, duration: Int): Int {
    var result = duration
    var current = timeSeries[0] + duration - 1
    for (i in 1..timeSeries.lastIndex) {
        result += duration - max(0, (current - timeSeries[i] + 1))
        current = timeSeries[i] + duration - 1
    }
    return result
}

private fun main() {

}

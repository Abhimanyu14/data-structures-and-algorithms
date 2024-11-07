package leetcode.leetcode_1732_find_the_highest_altitude

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/find-the-highest-altitude/
 *
 * Using iteration
 *
 * Stats
 * Runtime: 136 ms, faster than 85.29%
 * Memory Usage: 34.5 MB, less than 36.76%
 */
private fun largestAltitude(gain: IntArray): Int {
    var result = 0
    var current = 0
    gain.forEach {
        current += it
        result = max(result, current)
    }
    return result
}

private fun main() {

}

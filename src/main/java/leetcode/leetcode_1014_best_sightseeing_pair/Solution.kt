package leetcode.leetcode_1014_best_sightseeing_pair

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/best-sightseeing-pair/
 *
 * Data Structure - NA
 * Algorithm - Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 21 ms, faster than 28.57%
 * Memory Usage: 51.5 MB, less than 14.29%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun maxScoreSightseeingPair(values: IntArray): Int {
    var result = values[0] + values[1] - 1
    var carry = values[0]
    for (i in 1..values.lastIndex) {
        carry--
        result = max(result, values[i] + carry)
        carry = max(carry, values[i])
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/best-sightseeing-pair/
 *
 * Data Structure - NA
 * Algorithm - Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time - O(N ^ 2)
 * Space - O(1)
 */
private fun maxScoreSightseeingPairUsingBruteForce(values: IntArray): Int {
    var result = values[0] + values[1] - 1
    for (i in 0..<values.lastIndex) {
        for (j in (i + 1)..values.lastIndex) {
            result = max(result, values[i] + values[j] + i - j)
        }
    }
    return result
}

private fun main() {
}

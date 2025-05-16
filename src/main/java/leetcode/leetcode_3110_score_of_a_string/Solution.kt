package leetcode.leetcode_3110_score_of_a_string

import kotlin.math.abs

/**
 * leetcode - https://leetcode.com/problems/score-of-a-string/
 *
 * Using iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 178 ms, faster than 16.86%
 * Memory Usage: 36.1 MB, less than 11.54%
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Meta
 */
private fun scoreOfString(s: String): Int {
    var result = 0
    for (i in 0..<s.lastIndex) {
        result += abs(s[i] - s[i + 1])
    }
    return result
}

private fun main() {

}

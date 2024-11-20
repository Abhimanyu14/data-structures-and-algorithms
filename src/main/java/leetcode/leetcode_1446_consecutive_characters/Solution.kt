package leetcode.leetcode_1446_consecutive_characters

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/consecutive-characters/
 *
 * Using iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 9 ms, faster than 18.75%
 * Memory Usage: 37.3 MB, less than 22.86%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun maxPower(s: String): Int {
    var result = 1
    var prev = s[0]
    var current = 1
    for (i in 1..s.lastIndex) {
        if (s[i] == prev) {
            current++
            result = max(result, current)
        } else {
            prev = s[i]
            current = 1
        }
    }
    return result
}

private fun main() {

}

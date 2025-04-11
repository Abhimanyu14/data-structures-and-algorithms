package leetcode.leetcode_1422_maximum_score_after_splitting_a_string

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/maximum-score-after-splitting-a-string/?envType=daily-question&envId=2023-12-22
 *
 * Data Structure - NA
 * Algorithm - Two Pass
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 133 ms, faster than 100.00%
 * Memory Usage: 35.4 MB, less than 36.36%
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun maxScore(s: String): Int {
    var result = Int.MIN_VALUE
    val oneCount = s.count { it == '1' }
    var current = 0
    for (i in 0..<s.lastIndex) {
        if (s[i] == '1') {
            current++
        }
        result = max(result, ((i + 1 - current) + (oneCount - current)))
    }
    return result
}

private fun main() {

}

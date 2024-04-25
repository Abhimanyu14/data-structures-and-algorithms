package leetcode.leet_2300_to_2399.leet_2370_longest_ideal_subsequence

import kotlin.math.abs
import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/longest-ideal-subsequence/?envType=daily-question&envId=2024-04-25
 *
 * TODO(Abhi) - To revisit
 *
 * Using DP
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 231 ms, faster than 100.00%
 * Memory Usage: 37.1 MB, less than 100.00%
 *
 * Time -
 * Space -
 */
private fun longestIdealString(s: String, k: Int): Int {
    val dp = IntArray(26)
    var result = 0

    // Updating dp with the i-th character
    s.forEach { element ->
        val curr = element - 'a'
        var best = 0
        for (prev in 0..25) {
            if (abs(prev - curr) <= k) {
                best = max(best, dp[prev])
            }
        }

        // Appending s[i] to the previous longest ideal subsequence allowed
        dp[curr] = max(dp[curr], (best + 1))
        result = max(result, dp[curr])
    }
    return result
}

private fun main() {

}

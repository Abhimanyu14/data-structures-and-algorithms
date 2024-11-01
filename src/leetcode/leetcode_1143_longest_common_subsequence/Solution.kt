package leetcode.leetcode_1143_longest_common_subsequence

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/longest-common-subsequence/
 *
 * Using Memoization - improved
 *
 * Stats
 * Runtime: 237 ms, faster than 84.03%
 * Memory Usage: 38.6 MB, less than 85.42%
 */
private fun longestCommonSubsequence(text1: String, text2: String): Int {
    val memo: Array<IntArray> = Array(text1.length + 1) { IntArray(text2.length + 1) }
    for (i in text1.indices) {
        for (j in text2.indices) {
            memo[i][j] = -1
        }
    }

    fun memoSolve(p1: Int, p2: Int): Int {
        if (memo[p1][p2] != -1) {
            return memo[p1][p2]
        }
        val option1 = memoSolve(p1 + 1, p2)
        val firstOccurrence = text2.indexOf(text1[p1], p2)
        val option2 = if (firstOccurrence != -1) {
            1 + memoSolve(p1 + 1, firstOccurrence + 1)
        } else {
            0
        }
        memo[p1][p2] = max(option1, option2)
        return memo[p1][p2]
    }
    return memoSolve(0, 0)
}

/**
 * leetcode - https://leetcode.com/problems/longest-common-subsequence/
 *
 * Using Memoization
 *
 * Stats
 * Runtime: 237 ms, faster than 84.03%
 * Memory Usage: 38.6 MB, less than 85.42%
 */
private fun longestCommonSubsequenceUsingMemoization(text1: String, text2: String): Int {
    val memo: Array<IntArray> = Array(text1.length + 1) { IntArray(text2.length + 1) }
    for (i in text1.indices) {
        for (j in text2.indices) {
            memo[i][j] = -1
        }
    }

    fun memoSolve(p1: Int, p2: Int): Int {
        if (memo[p1][p2] != -1) {
            return memo[p1][p2]
        }
        val option1 = memoSolve(p1 + 1, p2)
        val firstOccurrence = text2.indexOf(text1[p1], p2)
        val option2 = if (firstOccurrence != -1) {
            1 + memoSolve(p1 + 1, firstOccurrence + 1)
        } else {
            0
        }
        memo[p1][p2] = max(option1, option2)
        return memo[p1][p2]
    }
    return memoSolve(0, 0)
}

private fun main() {
    longestCommonSubsequence("abcde", "ace")
}

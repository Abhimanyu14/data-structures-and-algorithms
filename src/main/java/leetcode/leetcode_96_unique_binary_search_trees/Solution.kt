package leetcode.leetcode_96_unique_binary_search_trees

/**
 * leetcode - https://leetcode.com/problems/unique-binary-search-trees/
 *
 * Using Dynamic Programming - Tabulation
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 33.8 MB, less than 6.90%
 *
 * Time -
 * Space -
 */
private fun numTrees(n: Int): Int {
    val dp = IntArray(n + 1)
    dp[0] = 1
    dp[1] = 1
    for (i in 2..n) {
        var current = 0
        for (j in 1..i) {
            current += (dp[j - 1] * dp[i - j])
        }
        dp[i] = current
    }
    return dp[n]
}

private fun main() {

}

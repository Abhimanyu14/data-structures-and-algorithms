package leetcode.leetcode_1420_build_array_where_you_can_find_the_maximum_exactly_k_comparisons

import java.util.Arrays

/**
 * leetcode - https://leetcode.com/problems/build-array-where-you-can-find-the-maximum-exactly-k-comparisons/
 *
 * TODO(Abhi) - To revisit
 *
 * Using Top down dynamic programming
 *
 * Stats
 * Runtime: 326 ms, faster than 100.00%
 * Memory Usage: 35.7 MB, less than 100.00%
 */
private class Solution {
    lateinit var memo: Array<Array<IntArray>>
    var mod = 1e9.toInt() + 7
    var n = 0
    var m = 0
    fun numOfArrays(n: Int, m: Int, k: Int): Int {
        memo = Array(n) { Array(m + 1) { IntArray(k + 1) } }
        for (i in 0 until n) {
            for (j in 0..m) {
                Arrays.fill(memo[i][j], -1)
            }
        }
        this.n = n
        this.m = m
        return dp(0, 0, k)
    }

    fun dp(i: Int, maxSoFar: Int, remain: Int): Int {
        if (i == n) {
            return if (remain == 0) {
                1
            } else 0
        }
        if (remain < 0) {
            return 0
        }
        if (memo[i][maxSoFar][remain] != -1) {
            return memo[i][maxSoFar][remain]
        }
        var ans = 0
        for (num in 1..maxSoFar) {
            ans = (ans + dp(i + 1, maxSoFar, remain)) % mod
        }
        for (num in maxSoFar + 1..m) {
            ans = (ans + dp(i + 1, num, remain - 1)) % mod
        }
        memo[i][maxSoFar][remain] = ans
        return ans
    }
}

private fun main() {

}

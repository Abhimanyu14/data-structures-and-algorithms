package leetcode.leetcode_2742_painting_the_walls

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/painting-the-walls/
 *
 * TODO(Abhi) - To revisit
 *
 * Using Top-Down Dynamic Programming
 *
 * Stats
 * Runtime: 278 ms, faster than 75.00%
 * Memory Usage: 45.1 MB, less than 100.00%
 */
private fun paintWalls(cost: IntArray, time: IntArray): Int {
    val memo = Array(cost.size) { IntArray(cost.size + 1) }
    fun dp(i: Int, remain: Int): Int {
        if (remain <= 0) {
            return 0
        }
        if (i == cost.size) {
            return 1e9.toInt()
        }
        if (memo[i][remain] != 0) {
            return memo[i][remain]
        }
        val paint = cost[i] + dp(i + 1, remain - 1 - time[i])
        val dontPaint = dp(i + 1, remain)
        memo[i][remain] = min(paint, dontPaint)
        return memo[i][remain]
    }
    return dp(0, cost.size)
}

private fun main() {

}

package leetcode.leetcode_799_champagne_tower

import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/champagne-tower/
 *
 * Using recursion and dp
 *
 * Stats
 * Runtime: 183 ms, faster than 58.33%
 * Memory Usage: 39.2 MB, less than 50.00%
 */
private fun champagneTower(poured: Int, query_row: Int, query_glass: Int): Double {
    if (poured == 0) {
        return 0.0
    }
    if (query_row == 0) {
        return 1.0
    }
    val dp = mutableMapOf<Pair<Int, Int>, Double>()
    dp[Pair(0, 0)] = poured.toDouble()

    fun getValue(row: Int, glass: Int): Double {
        if (glass < 0 || glass > row) {
            return 0.0
        }
        dp[Pair(row, glass)]?.let {
            return it
        }
        val left = max(0.0, ((getValue(row - 1, glass - 1) - 1) / 2))
        val right = max(0.0, ((getValue(row - 1, glass) - 1) / 2))

        // Can be inlined with values for memory efficiency - Memory Usage: 37.5 MB, less than 66.67%
        dp[Pair(row, glass)] = left + right
        return left + right
    }
    return min(1.0, getValue(query_row, query_glass))
}

private fun main() {

}

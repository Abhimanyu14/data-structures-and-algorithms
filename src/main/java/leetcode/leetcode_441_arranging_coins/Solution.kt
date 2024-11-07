package leetcode.leetcode_441_arranging_coins

import kotlin.math.sqrt

/**
 * leetcode - https://leetcode.com/problems/arranging-coins/
 *
 * Using maths - quadratic equation
 *
 * Stats
 * Runtime: 139 ms, faster than 90.67%
 * Memory Usage: 34.1 MB, less than 17.33%
 */
private fun arrangeCoins(n: Int): Int {
    return ((sqrt(1.0 + (8.0 * n)) - 1) / 2).toInt()
}

private fun main() {

}

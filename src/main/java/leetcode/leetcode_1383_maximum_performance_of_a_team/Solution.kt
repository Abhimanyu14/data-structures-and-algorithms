package leetcode.leetcode_1383_maximum_performance_of_a_team

import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/maximum-performance-of-a-team/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - NA
 * Algorithm - Recursion
 *
 * Difficulty - Hard
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time -
 * Space -
 */
private fun maxPerformance(n: Int, speed: IntArray, efficiency: IntArray, k: Int): Int {
    var result = 0
    fun getPerformance(index: Int, minEfficiency: Int, speedSum: Long, count: Int) {
        if (count <= k) {
            result = max(result, ((minEfficiency * speedSum) % 1_000_000_007).toInt())
        }
        if (index == n || count == k) {
            return
        }
        getPerformance(index + 1, minEfficiency, speedSum, count)
        getPerformance(index + 1, min(minEfficiency, efficiency[index]), speedSum + speed[index], count + 1)
    }
    getPerformance(0, Int.MAX_VALUE, 0L, 0)
    return result
}

private fun main() {

}

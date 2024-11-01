package leetcode.leetcode_700_to_799.leetcode_746_min_cost_climbing_stairs

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/min-cost-climbing-stairs/
 *
 * Using two pointer - Optimized dynamic programming
 *
 * Stats
 * Runtime: 155 ms, faster than 93.99%
 * Memory Usage: 36.4 MB, less than 75.97%
 */
private fun minCostClimbingStairs(cost: IntArray): Int {
    var prev = cost[0]
    var current = cost[1]
    var i = 2
    var temp: Int
    while (i < cost.size) {
        temp = current
        current = min(current, prev) + cost[i]
        prev = temp
        i++
    }
    return min(prev, current)
}

private fun main() {

}

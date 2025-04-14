package leetcode.leetcode_121_best_time_to_buy_and_sell_stock

import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Two Pointers
 * Algorithm - Iteration
 *
 * Maths methods - [min], [max]
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Meta
 */
private fun maxProfit(prices: IntArray): Int {
    var result = 0
    var minSoFar = prices[0]
    for (i in 1..prices.lastIndex) {
        minSoFar = min(minSoFar, prices[i])
        result = max(result, prices[i] - minSoFar)
    }
    return result
}

private fun maxProfit1(prices: IntArray): Int {
    // Cannot buy and sell in same day as profit will be zero
    if (prices.size == 1) {
        return 0
    }
    var left = 0
    var result = 0
    for (right in 1..prices.lastIndex) {
        if (prices[left] > prices[right]) {
            left = right
        } else {
            result = max(result, prices[right] - prices[left])
        }
    }
    return result
}

private fun main() {

}

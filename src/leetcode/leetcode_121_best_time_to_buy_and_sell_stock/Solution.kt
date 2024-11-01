package leetcode.leetcode_121_best_time_to_buy_and_sell_stock

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * Using two pointers
 *
 * Stats
 * Runtime: 537 ms, faster than 13.22%
 * Memory Usage: 59 MB, less than 16.39%
 */
private fun maxProfit(prices: IntArray): Int {
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

package leetcode.leetcode_122_best_time_to_buy_and_sell_stock_ii

/**
 * leetcode - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 *
 * Data Structure - NA
 * Algorithm - Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private fun maxProfit(prices: IntArray): Int {
    var result = 0
    for (i in 1..prices.lastIndex) {
        if (prices[i] > prices[i - 1]) {
            result += prices[i] - prices[i - 1]
        }
    }
    return result
}

private fun main() {

}

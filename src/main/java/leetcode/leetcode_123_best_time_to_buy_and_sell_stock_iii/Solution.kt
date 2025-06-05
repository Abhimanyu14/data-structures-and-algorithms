package leetcode.leetcode_123_best_time_to_buy_and_sell_stock_iii

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - NA
 * Algorithm - Dynamic Programming - Memoization - Recursion
 *
 * Difficulty - Hard
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private fun maxProfit(prices: IntArray): Int {
    val cache = mutableMapOf<Triple<Int, Int, Boolean>, Int>()
    fun getMaxProfit(index: Int, remaining: Int, holding: Boolean): Int {
        if (index == prices.size) {
            return 0
        }
        if (remaining == 0) {
            return 0
        }
        cache[Triple(index, remaining, holding)]?.let {
            return it
        }
        cache[Triple(index, remaining, holding)] = max(
            if (holding) {
                getMaxProfit(index + 1, remaining - 1, false) + prices[index]
            } else {
                getMaxProfit(index + 1, remaining , true)- prices[index]
            },
            getMaxProfit(index + 1, remaining, holding),
        )
        return cache[Triple(index, remaining, holding)]!!
    }
    return getMaxProfit(0, 2, false)
}

private fun main() {

}

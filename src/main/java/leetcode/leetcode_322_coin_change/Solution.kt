package leetcode.leetcode_322_coin_change

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/coin-change/
 *
 * Data Structure - Array
 * Algorithm - Dynamic Programming - Tabulation
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun coinChange(coins: IntArray, amount: Int): Int {
    val dp = IntArray(amount + 1) { amount + 1 }
    dp[0] = 0
    for (i in 1..amount) {
        for (coin in coins) {
            if (coin <= i) {
                dp[i] = min(dp[i], dp[i - coin] + 1)
            }
        }
    }
    return if (dp[amount] > amount) {
        -1
    } else {
        dp[amount]
    }
}

private fun main() {

}

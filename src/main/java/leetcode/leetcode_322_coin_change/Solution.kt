package leetcode.leetcode_322_coin_change

/**
 * leetcode - https://leetcode.com/problems/coin-change/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty -
 *
 * Stats
 *
 * Time -
 * Space -
 */
fun coinChange(coins: IntArray, amount: Int, result: Int): Int {
    if (amount == 0) {
        return result
    }
    if (amount < 0) {
        return Int.MAX_VALUE
    }

    return 0
}

fun coinChangeDriver(coins: IntArray, amount: Int): Int {
    return coinChange(coins, amount, 0)
}

private fun main() {

}

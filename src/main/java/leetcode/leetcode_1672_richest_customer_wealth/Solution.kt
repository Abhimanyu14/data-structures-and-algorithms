package leetcode.leetcode_1672_richest_customer_wealth

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/richest-customer-wealth/
 *
 * Using iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 16 ms, faster than 52.70%
 * Memory Usage: 37.3 MB, less than 72.33%
 *
 * Time -
 * Space -
 */
private fun maximumWealth(accounts: Array<IntArray>): Int {
    var result = 0
    accounts.forEach {
        result = max(result, it.sum())
    }
    return result
}


private fun main() {

}

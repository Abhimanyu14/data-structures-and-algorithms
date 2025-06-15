package leetcode.leetcode_2303_calculate_amount_paid_in_taxes

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/calculate-amount-paid-in-taxes/description/?envType=company&envId=facebook&favoriteSlug=facebook-all
 *
 * Data Structure - NA
 * Algorithm - Iteration
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
private fun calculateTax(brackets: Array<IntArray>, income: Int): Double {
    var result = 0.0
    var covered = 0
    for ((upper, percent) in brackets) {
        val current = min(upper, income)
        result += (current - covered) * percent
        covered = current
        if (covered == income) {
            break
        }
    }
    return result / 100
}

private fun main() {

}

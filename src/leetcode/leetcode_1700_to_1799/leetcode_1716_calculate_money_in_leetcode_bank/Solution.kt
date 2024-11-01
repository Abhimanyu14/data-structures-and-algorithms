package leetcode.leetcode_1700_to_1799.leetcode_1716_calculate_money_in_leetcode_bank

/**
 * leetcode - https://leetcode.com/problems/calculate-money-in-leetcode-bank/
 *
 * Using Math
 *
 * Stats
 * Runtime: 116 ms, faster than 66.67%
 * Memory Usage: 33.3 MB, less than 40.00%
 */
private fun totalMoney(n: Int): Int {
    val a = n / 7
    val b = n % 7
    return ((7 * a * a) + (b * b) + (49 * a) + b + (2 * a * b)) / 2
}

private fun main() {

}

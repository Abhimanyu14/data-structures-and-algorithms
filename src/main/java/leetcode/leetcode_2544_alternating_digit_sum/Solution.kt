package leetcode.leetcode_2544_alternating_digit_sum

import kotlin.math.log10

/**
 * leetcode - https://leetcode.com/problems/alternating-digit-sum/
 *
 * Data Structure - NA
 * Algorithm - Digit Extraction, Number of Digits Count and Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 34 MB, less than 50.00%
 *
 * Time -
 * Space -
 */
private fun alternateDigitSum(n: Int): Int {
    var result = 0
    val numberOfDigits = log10(n.toDouble()).toInt() + 1
    var multiplier = if (numberOfDigits % 2 == 1) {
        1
    } else {
        -1
    }
    var temp = n
    while (temp != 0) {
        result += (multiplier * (temp % 10))
        temp /= 10
        multiplier *= -1
    }
    return result
}

private fun main() {

}

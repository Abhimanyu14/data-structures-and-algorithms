package leetcode.leetcode_1295_find_numbers_with_even_number_of_digits

import kotlin.math.log10

/**
 * leetcode - https://leetcode.com/problems/find-numbers-with-even-number-of-digits/description/?envType=daily-question&envId=2025-04-30
 *
 * Data Structure -
 * Algorithm - Logarithm
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N * log(M)) // M - number of digits
 * Space - O(1)
 *
 * Companies - Microsoft
 */
private fun findNumbers(nums: IntArray): Int {
    return nums.count { log10(it.toDouble()).toInt() % 2 == 1 }

    /**
     * Note: This is preferred to avoid floating point operation precision errors
     * nums.count { (log10(it.toDouble()) + 1e-9).toInt() % 2 == 0 }
     */
}

/**
 * leetcode - https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 *
 * Using count lambda
 *
 * Stats
 * Runtime: 324 ms, faster than 59.26%
 * Memory Usage: 39.8 MB, less than 29.63%
 */
private fun findNumbersUsingString(nums: IntArray): Int {
    return nums.count { it.toString().length % 2 == 0 }
}

private fun main() {

}

package leetcode.leetcode_2338_count_the_number_of_ideal_arrays

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/count-the-number-of-ideal-arrays/description/?envType=daily-question&envId=2025-04-22
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm - Recursion
 *
 * Difficulty - Hard
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time -
 * Space -
 *
 * Companies - Microsoft
 */

/**
 * leetcode - https://leetcode.com/problems/count-the-number-of-ideal-arrays/description/?envType=daily-question&envId=2025-04-22
 *
 * Data Structure - NA
 * Algorithm - Recursion
 *
 * Difficulty - Hard
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time - O(maxValue ^ maxValue)
 * Space - O(maxValue ^ maxValue)
 *
 * Companies - Microsoft
 */
private fun idealArraysUsingBruteForce(n: Int, maxValue: Int): Int {
    fun count(remaining: Int, previous: Int): Int {
        if (remaining == 0) {
            return 1
        }
        var result = 0
        var i = previous
        while (i <= maxValue) {
            result = (result + count(remaining - 1, i)) % 1_000_000_007
            i += previous
        }
        return result
    }
    return count(n, 1)
}

private fun main() {

}

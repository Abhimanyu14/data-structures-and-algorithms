package leetcode.leetcode_1922_count_good_numbers

import kotlin.math.pow

/**
 * leetcode - https://leetcode.com/problems/count-good-numbers/
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
 *
 * Companies -
 */
private fun countGoodNumbers(n: Long): Int {
    val multiplier = if (n.toInt() % 2 == 0) {
        1
    } else {
        5
    }
    return (((20.0.pow((n / 2).toInt())) * multiplier) % 1_000_000_007).toInt()
}

package leetcode.leetcode_1500_to_1599.leetcode_1503_last_moment_before_all_ants_fall_out_of_a_plank

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/
 *
 * Using iteration
 *
 * Stats
 * Runtime: 186 ms, faster than 100.00%
 * Memory Usage: 40 MB, less than 83.33%
 */
private fun getLastMoment(n: Int, left: IntArray, right: IntArray): Int {
    var result = 0
    left.forEach {
        result = max(result, it)
    }
    right.forEach {
        result = max(result, n - it)
    }
    return result
}

fun main() {

}

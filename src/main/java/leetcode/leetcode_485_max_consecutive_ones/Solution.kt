package leetcode.leetcode_485_max_consecutive_ones

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/max-consecutive-ones/
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
 * Companies - Google, Meta
 */
private fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var result = 0
    var current = 0
    for (num in nums) {
        if (num == 1) {
            current++
            result = max(result, current)
        } else {
            current = 0
        }
    }
    return result
}

private fun main() {

}

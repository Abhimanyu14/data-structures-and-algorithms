package leetcode.leetcode_2400_to_2499.leetcode_2419_longest_subarray_with_maximum_bitwise_and

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty -
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun longestSubarray(nums: IntArray): Int {
    var result = 0
    var maxVal = 0
    var currentStreak = 0
    nums.forEach { num ->
        if (maxVal < num) {
            maxVal = num
            currentStreak = 0
            result = 0
        }
        if (maxVal == num) {
            currentStreak++
        } else {
            currentStreak = 0
        }
        result = max(result, currentStreak)
    }
    return result
}

private fun main() {

}

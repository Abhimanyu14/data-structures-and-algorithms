package leetcode.leetcode_674_longest_continuous_increasing_subsequence

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/longest-continuous-increasing-subsequence/
 *
 * Using iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 17 ms, faster than 9.09%
 * Memory Usage: 40.6 MB, less than 5.41%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun findLengthOfLCIS(nums: IntArray): Int {
    var result = 1
    var prev = nums[0]
    var current = 1
    for (i in 1..nums.lastIndex) {
        if (nums[i] > prev) {
            current++
            result = max(result, current)
        } else {
            current = 1
        }
        prev = nums[i]
    }
    return result
}

private fun main() {

}

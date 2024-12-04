package leetcode.leetcode_1004_max_consecutive_ones_iii

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/max-consecutive-ones-iii/
 *
 * Data Structure - NA
 * Algorithm - sliding Window
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 4 ms, faster than 89.14%
 * Memory Usage: 40.2 MB, less than 73.02%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun longestOnes(nums: IntArray, k: Int): Int {
    var result = 0
    var zeroCount = 0
    var right = 0
    while (right <= nums.lastIndex && (nums[right] == 1 || zeroCount < k)) {
        if (nums[right] == 0) {
            zeroCount++
        }
        result++
        right++
    }
    if (right == nums.size) {
        return result
    }
    var current = result
    var left = 0
    while (right <= nums.lastIndex) {
        while (left <= right && nums[left] == 1) {
            current--
            left++
        }
        left++
        right++
        while (right <= nums.lastIndex && nums[right] == 1) {
            current++
            right++
        }
        result = max(result, current)
    }
    return result
}

private fun main() {

}

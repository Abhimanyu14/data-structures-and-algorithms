package leetcode.leetcode_1004_max_consecutive_ones_iii

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/max-consecutive-ones-iii/
 *
 * Using sliding window
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
    var index = 0
    while (index < nums.size && (nums[index] == 1 || zeroCount < k)) {
        result++
        if (nums[index] == 0) {
            zeroCount++
        }
        index++
    }
    if (index == nums.size) {
        return result
    }
    var current = result
    var start = 0
    while (index < nums.size) {
        while (nums[start] == 1) {
            current--
            start++
        }
        start++
        index++
        while (index < nums.size && nums[index] == 1) {
            current++
            index++
        }
        result = max(result, current)
    }
    return result
}

private fun main() {

}

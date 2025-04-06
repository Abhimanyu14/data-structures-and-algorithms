package leetcode.leetcode_643_maximum_average_subarray_i

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/maximum-average-subarray-i/description/?envType=company&envId=google&favoriteSlug=google-thirty-days&difficulty=EASY
 *
 * Data Structure - NA
 * Algorithm - Sliding Window
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 23 ms, faster than 30.24%
 * Memory Usage: 54.3 MB, less than 6.92%
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Google, Meta
 */
private fun findMaxAverage(nums: IntArray, k: Int): Double {
    var result: Double
    var currentSum = 0.0
    var i = 0
    while (i < k) {
        currentSum += nums[i]
        i++
    }
    result = currentSum
    while (i <= nums.lastIndex) {
        currentSum += nums[i] - nums[i - k]
        result = max(result, currentSum)
        i++
    }
    return result / k
}

private fun main() {

}

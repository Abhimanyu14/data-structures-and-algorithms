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
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Google, Meta
 */
private fun findMaxAverage(nums: IntArray, k: Int): Double {
    var result: Double
    var sum = 0.0
    var index = 0
    while (index <= nums.lastIndex && index < k) {
        sum += nums[index]
        index++
    }
    result = sum / index
    while (index <= nums.lastIndex) {
        sum = sum + nums[index] - nums[index - k]
        result = max(result, sum / k)
        index++
    }
    return result
}

private fun main() {

}

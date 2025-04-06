package leetcode.leetcode_53_maximum_subarray

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/maximum-subarray/
 * https://leetcode.com/problems/maximum-subarray/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - NA
 * Algorithm - Dynamic programming - Kadane's Algorithm
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 13 ms, faster than 12.57%
 * Memory Usage: 64.19 MB, less than 28.96%
 *
 * Time -
 * Space -
 *
 * Companies - Google, Meta
 */
private fun maxSubArray(nums: IntArray): Int {
    var result = nums[0]
    var current = nums[0]
    for (i in 1..nums.lastIndex) {
        current = max(current, 0) + nums[i]
        result = max(result, current)
    }
    return result
}

private fun main() {
    println(maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    println(maxSubArray(intArrayOf(1)))
    println(maxSubArray(intArrayOf(5, 4, -1, 7, 8)))
}

package leetcode.leetcode_53_maximum_subarray

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/maximum-subarray/
 *
 * Using dynamic programming - Kadane's Algorithm
 *
 * Stats
 * Runtime: 532 ms, faster than 56.67%
 * Memory Usage: 58.7 MB, less than 55.30%
 */
private fun maxSubArray(nums: IntArray): Int {
    var localMax = nums[0]
    var globalMax = nums[0]
    for (i in 1..nums.lastIndex) {
        localMax = max(nums[i], localMax + nums[i])
        globalMax = max(globalMax, localMax)
    }
    return globalMax
}

private fun main() {
    println(maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    println(maxSubArray(intArrayOf(1)))
    println(maxSubArray(intArrayOf(5, 4, -1, 7, 8)))
}

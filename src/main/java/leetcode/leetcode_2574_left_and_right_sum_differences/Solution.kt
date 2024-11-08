package leetcode.leetcode_2574_left_and_right_sum_differences

import kotlin.math.abs

/**
 * leetcode - https://leetcode.com/problems/left-and-right-sum-differences/
 *
 * Using sum of array
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 17 ms, faster than 71.43%
 * Memory Usage: 40.4 MB, less than 26.32%
 *
 * Time - O(N)
 * Space - O(N)
 */
private fun leftRightDifference(nums: IntArray): IntArray {
    val result = IntArray(nums.size)
    val sum = nums.sum()
    var leftSum = 0
    for (i in nums.indices) {
        result[i] = abs(leftSum - sum + leftSum + nums[i])
        leftSum += nums[i]
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/left-and-right-sum-differences/
 *
 * Using 3 arrays
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 19 ms, faster than 57.14%
 * Memory Usage: 40 MB, less than 31.58%
 *
 * Time - O(N)
 * Space - O(N)
 */
private fun leftRightDifferenceUsing3Arrays(nums: IntArray): IntArray {
    val result = IntArray(nums.size)
    val leftSum = IntArray(nums.size)
    val rightSum = IntArray(nums.size)
    for (i in 1..nums.lastIndex) {
        leftSum[i] = leftSum[i - 1] + nums[i - 1]
        rightSum[nums.lastIndex - i] = rightSum[nums.size - i] + nums[nums.size - i]
    }
    for (i in nums.indices) {
        result[i] = abs(leftSum[i] - rightSum[i])
    }
    return result
}

private fun main() {

}

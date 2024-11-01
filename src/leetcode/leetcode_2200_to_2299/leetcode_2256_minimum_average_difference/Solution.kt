package leetcode.leetcode_2200_to_2299.leetcode_2256_minimum_average_difference

import kotlin.math.abs

/**
 * leetcode - https://leetcode.com/problems/minimum-average-difference/
 *
 * Using simple variables and loops
 *
 * Stats
 * Runtime: 1057 ms, faster than 100.00%
 * Memory Usage: 85.1 MB, less than 100.00%
 */
private fun minimumAverageDifference(nums: IntArray): Int {
    val sum: Long = nums.sum().toLong()
    var result = -1
    var minAvgDiff = Int.MAX_VALUE
    var currentPrefixSum = 0L
    for (i in nums.indices) {
        currentPrefixSum += nums[i]
        val leftAvg: Long = (currentPrefixSum / (i + 1))
        val rightAvg: Long = if (i == nums.lastIndex) {
            (sum - currentPrefixSum)
        } else {
            ((sum - currentPrefixSum) / (nums.lastIndex - i))
        }
        val currentDiff = abs(leftAvg - rightAvg).toInt()
        if (currentDiff < minAvgDiff) {
            minAvgDiff = currentDiff
            result = i
        }
    }
    return result
}

private fun minimumAverageDifferenceUsingPrefixSum(nums: IntArray): Int {
    val prefixSum = IntArray(nums.size)
    val suffixSum = IntArray(nums.size)
    prefixSum[0] = nums[0]
    suffixSum[nums.lastIndex] = 0
    for (i in 1..nums.lastIndex) {
        prefixSum[i] = prefixSum[i - 1] + nums[i]
        suffixSum[nums.size - i - 1] = suffixSum[nums.size - i] + nums[nums.size - i]
    }

    var min = Int.MAX_VALUE
    var index = -1
    var temp: Int
    var prefixDivRes: Int
    var suffixDivRes: Int
    for (i in nums.indices) {
        prefixDivRes = (prefixSum[i] / (i + 1))
        suffixDivRes = if (nums.size - i - 1 == 0) {
            0
        } else {
            suffixSum[i] / (nums.size - i - 1)
        }
        temp = abs(prefixDivRes - suffixDivRes)
        if (temp < min) {
            min = temp
            index = i
        }
    }
    return index
}

private fun main() {

}

package leetcode.leetcode_1695_maximum_erasure_value

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/maximum-erasure-value/description/?envType=daily-question&envId=2025-07-22
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Amazon
 */
private fun maximumUniqueSubarrayUsingSlidingWindow(nums: IntArray): Int {
    var result = nums[0]
    val currentWindowNums = mutableSetOf<Int>()
    var currentSum = nums[0]
    var start = 0
    currentWindowNums.add(nums[0])
    for (i in 1..nums.lastIndex) {
        while (currentWindowNums.contains(nums[i])) {
            currentSum -= nums[start]
            currentWindowNums.remove(nums[start])
            start++
        }
        currentSum += nums[i]
        currentWindowNums.add(nums[i])
        result = max(result, currentSum)
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/maximum-erasure-value/description/?envType=daily-question&envId=2025-07-22
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Amazon
 */
private fun maximumUniqueSubarrayUsingPrefixSum(nums: IntArray): Int {
    var result = nums[0]
    val prefixSum = IntArray(nums.size)
    prefixSum[0] = nums[0]
    val indexMap = mutableMapOf<Int, Int>() // value, Index
    indexMap[nums[0]] = 0
    var toRemove = 0
    for (i in 1..nums.lastIndex) {
        prefixSum[i] = prefixSum[i - 1] + nums[i]
        if (indexMap.contains(nums[i])) {
            toRemove =  max(toRemove, prefixSum[indexMap.getOrDefault(nums[i], -1)])
        }
        result = max(result, prefixSum[i] - toRemove)
        indexMap[nums[i]] = i
    }
    return result
}

private fun main() {

}

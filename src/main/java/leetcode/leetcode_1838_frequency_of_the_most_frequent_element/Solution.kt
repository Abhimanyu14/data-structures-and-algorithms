package leetcode.leetcode_1838_frequency_of_the_most_frequent_element

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/frequency-of-the-most-frequent-element/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Two Pointers
 * Algorithm - Sliding Window
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N * log(N))
 * Space - O(N)
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private fun maxFrequency(nums: IntArray, k: Int): Int {
    var result = 1
    val sortedNums = nums.sorted()
    val prefixSum = IntArray(nums.size)
    for (i in 1..sortedNums.lastIndex) {
        prefixSum[i] = prefixSum[i - 1] + sortedNums[i - 1]
    }
    var right = sortedNums.lastIndex
    var left = sortedNums.lastIndex
    while (left > 0) {
        left--
        if ((sortedNums[right] * (right - left + 1)) <= (sortedNums[right] + prefixSum[right] - prefixSum[left] + k)) {
            result = max(result, right - left + 1)
        } else {
            right--
        }
    }
    return result
}

private fun maxFrequencyUsingChangingWindow(nums: IntArray, k: Int): Int {
    nums.sort()
    var left = 0
    var result = 1
    var sum = 0L
    for (right in 1..<nums.size) {
        sum += (nums[right] - nums[right - 1]) * (right - left)
        while (sum > k) {
            sum -= (nums[right] - nums[left])
            left++
        }
        result = max(result, right - left + 1)
    }
    return result
}

private fun main() {

}

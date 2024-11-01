package leetcode.leetcode_2900_to_2999.leetcode_2958_length_of_longest_subarray_with_at_most_k_frequency

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/
 *
 * Using sliding window
 *
 * Stats
 * Runtime: 828 ms, faster than 9.09%
 * Memory Usage: 62.6 MB, less than 45.45%
 */
private fun maxSubarrayLength(nums: IntArray, k: Int): Int {
    val counter = mutableMapOf<Int, Int>()
    var left = 0
    var right = 0
    var result = 1
    counter[nums[0]] = 1
    while (right < nums.lastIndex) {
        right++
        counter[nums[right]] = counter.getOrDefault(nums[right], 0) + 1
        while (counter.getOrDefault(nums[right], 0) > k) {
            counter[nums[left]] = counter.getOrDefault(nums[left], 0) - 1
            left++
        }
        result = max(result, right - left + 1)
    }
    return result
}

private fun main() {

}

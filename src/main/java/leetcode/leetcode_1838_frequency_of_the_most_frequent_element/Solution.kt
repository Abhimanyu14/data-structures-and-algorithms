package leetcode.leetcode_1838_frequency_of_the_most_frequent_element

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/frequency-of-the-most-frequent-element/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm - Sliding Window
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 569 ms, faster than 66.67%
 * Memory Usage: 56.2 MB, less than 66.67%
 *
 * Time -
 * Space -
 *
 * Companies -
 */
private fun maxFrequency(nums: IntArray, k: Int): Int {
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

package leetcode.leetcode_209_minimum_size_subarray_sum

/**
 * leetcode - https://leetcode.com/problems/minimum-size-subarray-sum/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Two Pointers
 * Algorithm - Sliding Window
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 19 ms, faster than 10.00%
 * Memory Usage: 52.1 MB, less than 5.25%
 *
 * Time - O(2 * N)
 * Space - O(1)
 */
private fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var result = Int.MAX_VALUE
    var left = 0
    var right = 0
    var currentSum = 0
    while (right <= nums.lastIndex) {
        currentSum += nums[right]
        while (currentSum >= target) {
            if ((right - left + 1) < result) {
                result = right - left + 1
            }
            currentSum -= nums[left]
            left++
        }
        right++
    }
    return if (result == Int.MAX_VALUE) {
        0
    } else {
        result
    }
}

private fun main() {

}

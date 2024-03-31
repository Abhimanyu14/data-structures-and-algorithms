package leetcode.leet_2400_to_2499.leet_2444_count_subarrays_with_fixed_bounds

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/count-subarrays-with-fixed-bounds/
 *
 * TODO(Abhi) - To revisit
 *
 * Using two pointer
 *
 * Difficulty - Hard
 *
 * Stats
 * Runtime: 444 ms, faster than 100.00%
 * Memory Usage: 52.3 MB, less than 100.00%
 *
 * Time -
 * Space -
 */
private fun countSubarrays(nums: IntArray, minK: Int, maxK: Int): Long {
    var result = 0L
    var minKIndex = -1
    var maxKIndex = -1
    var culpritIndex = -1
    for (i in nums.indices) {
        if (nums[i] < minK || nums[i] > maxK) {
            culpritIndex = i
        }
        if (nums[i] == minK) {
            minKIndex = i
        }
        if (nums[i] == maxK) {
            maxKIndex = i
        }
        val smaller = minOf(minKIndex, maxKIndex).toLong()
        val temp = smaller - culpritIndex
        result += max(temp, 0)
    }
    return result
}

private fun main() {

}

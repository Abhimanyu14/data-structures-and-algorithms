package leetcode.leetcode_3350_adjacent_increasing_subarrays_detection_ii

import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/adjacent-increasing-subarrays-detection-ii/
 *
 * Using iteration
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 944 ms, faster than 57.14%
 * Memory Usage: 82 MB, less than 69.39%
 *
 * Time -
 * Space -
 */
private fun maxIncreasingSubarrays(nums: List<Int>): Int {
    var result = 1
    var count = 1
    var prevCount = 1
    for (i in 1..nums.lastIndex) {
        if (nums[i] > nums[i - 1]) {
            count++
            result = max(result, (count / 2))
            result = max(result, min(count, prevCount))
        } else {
            prevCount = count
            count = 1
        }
    }
    return result
}

private fun main() {

}

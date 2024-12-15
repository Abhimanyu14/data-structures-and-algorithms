package leetcode.leetcode_16_3sum_closest

import kotlin.math.abs

/**
 * leetcode - https://leetcode.com/problems/3sum-closest/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 */

/**
 * leetcode - https://leetcode.com/problems/3sum-closest/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - NA
 * Algorithm - Brute Force
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 567 ms, faster than 5.03%
 * Memory Usage: 40 MB, less than 13.97%
 *
 * Time - O(N ^ 3)
 * Space - O(1)
 */
private fun threeSumClosest(nums: IntArray, target: Int): Int {
    var result = nums[0] + nums[1] + nums[2]
    for (i in 0..(nums.lastIndex - 2)) {
        for (j in (i + 1)..(nums.lastIndex - 1)) {
            for (k in (j + 1)..(nums.lastIndex)) {
                if (abs(result - target) > abs((nums[i] + nums[j] + nums[k]) - target)) {
                    result = nums[i] + nums[j] + nums[k]
                }
            }
        }
    }
    return result
}

private fun main() {

}

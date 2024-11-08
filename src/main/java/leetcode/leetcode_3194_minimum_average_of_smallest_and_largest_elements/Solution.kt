package leetcode.leetcode_3194_minimum_average_of_smallest_and_largest_elements

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/minimum-average-of-smallest-and-largest-elements/
 *
 * Using iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 19 ms, faster than 50.00%
 * Memory Usage: 41.7 MB, less than 42.31%
 *
 * Time -
 * Space -
 */
private fun minimumAverage(nums: IntArray): Double {
    nums.sort()
    var result = (nums[0].toDouble() + nums[nums.lastIndex]) / 2
    for (i in 1..<(nums.size / 2)) {
        result = min(result, (nums[i].toDouble() + nums[nums.lastIndex - i]) / 2)
    }
    return result
}

private fun main() {

}

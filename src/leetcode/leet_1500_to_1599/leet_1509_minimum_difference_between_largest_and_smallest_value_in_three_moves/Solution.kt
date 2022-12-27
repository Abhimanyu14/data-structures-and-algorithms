package leetcode.leet_1500_to_1599.leet_1509_minimum_difference_between_largest_and_smallest_value_in_three_moves

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
 *
 * Using sorting
 *
 * Stats
 * Runtime: 416 ms, faster than 87.50%
 * Memory Usage: 52.1 MB, less than 87.50%
 */
private fun minDifference(nums: IntArray): Int {
    if (nums.size <= 4) {
        return 0
    }
    nums.sort()
    var result = nums[nums.lastIndex - 3] - nums[0]
    for (i in 1..3) {
        result = min(result, nums[nums.lastIndex - 3 + i] - nums[0 + i])
    }
    return result
}

private fun main() {

}

package leetcode.leetcode_1500_to_1599.leetcode_1509_minimum_difference_between_largest_and_smallest_value_in_three_moves

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/?envType=daily-question&envId=2024-07-03
 *
 * Using
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 398 ms, faster than 40.00%
 * Memory Usage: 53 MB, less than 20.00%
 *
 * Time -
 * Space -
 */
private fun minDifference(nums: IntArray): Int {
    if (nums.size <= 4) {
        return 0
    }
    nums.sort()
    var result = nums[nums.lastIndex - 3] - nums[0]
    result = min(result, nums[nums.lastIndex - 2] - nums[1])
    result = min(result, nums[nums.lastIndex - 1] - nums[2])
    result = min(result, nums[nums.lastIndex] - nums[3])
    return result
}

/**
 * leetcode - https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
 *
 * Using sorting
 *
 * Stats
 * Runtime: 416 ms, faster than 87.50%
 * Memory Usage: 52.1 MB, less than 87.50%
 */
private fun minDifferenceWithLoop(nums: IntArray): Int {
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

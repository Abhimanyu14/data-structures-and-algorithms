package leetcode.leetcode_3423_maximum_difference_between_adjacent_elements_in_a_circular_array

import kotlin.math.abs
import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/maximum-difference-between-adjacent-elements-in-a-circular-array/description/?envType=daily-question&envId=2025-06-12
 *
 * Data Structure - NA
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies -
 */
private fun maxAdjacentDistance(nums: IntArray): Int {
    var result = abs(nums.last() - nums.first())
    for (i in 1..nums.lastIndex) {
        result = max(result, abs(nums[i] - nums[i - 1]))
    }
    return result
}

private fun main() {

}

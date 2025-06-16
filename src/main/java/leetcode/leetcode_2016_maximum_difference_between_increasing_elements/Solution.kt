package leetcode.leetcode_2016_maximum_difference_between_increasing_elements

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/maximum-difference-between-increasing-elements/description/?envType=daily-question&envId=2025-06-16
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
 * Companies - Google
 */
private fun maximumDifference(nums: IntArray): Int {
    var result = -1
    var smallest = nums[0]
    for (i in 1..nums.lastIndex) {
        if (nums[i] < smallest) {
            smallest = nums[i]
        } else if (nums[i] > smallest) {
            result = max(result, nums[i] - smallest)
        }
    }
    return result
}

private fun main() {

}

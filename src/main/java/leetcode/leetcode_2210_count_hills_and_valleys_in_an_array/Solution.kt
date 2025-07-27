package leetcode.leetcode_2210_count_hills_and_valleys_in_an_array

import kotlin.math.sign

/**
 * leetcode - https://leetcode.com/problems/count-hills-and-valleys-in-an-array/
 *
 * Data Structure - NA
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 165 ms, faster than 50.00%
 * Memory Usage: 34.1 MB, less than 70.00%
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Google, Meta, Microsoft
 */
private fun countHillValley(nums: IntArray): Int {
    var i = 1
    while (i <= nums.lastIndex && nums[i - 1] == nums[i]) {
        i++
    }
    if (i > nums.lastIndex) {
        return 0
    }

    var result = 0
    fun getSlope(x: Int, y: Int): Int {
        return if (x > y) {
            -1
        } else if (x == y) {
            0
        } else {
            1
        }
    }

    var slope = getSlope(nums[i - 1], nums[i])
    while (i <= nums.lastIndex) {
        val current = getSlope(nums[i - 1], nums[i])
        if (current != 0 && current != slope) {
            result++
            slope = current
        }
        i++
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/count-hills-and-valleys-in-an-array/
 *
 * Data Structure -
 * Algorithm - Iteration
 * [Int.sign] => return sign of an [Int] => -1, 0, or 1
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 165 ms, faster than 50.00%
 * Memory Usage: 34.1 MB, less than 70.00%
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Google, Meta, Microsoft
 */
private fun countHillValleyUsingSign(nums: IntArray): Int {
    var result = 0
    var slope = 0
    var i = 1
    var temp: Int

    // Skip initial equal numbers
    while (slope == 0) {
        temp = (nums[i] - nums[i - 1]).sign
        slope = temp
        i++
    }

    while (i < nums.size) {
        temp = (nums[i] - nums[i - 1]).sign
        if (temp != 0 && temp != slope) {
            result++
            slope = temp
        }
        i++
    }
    return result
}

private fun main() {

}

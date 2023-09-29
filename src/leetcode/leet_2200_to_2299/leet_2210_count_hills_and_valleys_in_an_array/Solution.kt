package leetcode.leet_2200_to_2299.leet_2210_count_hills_and_valleys_in_an_array

import kotlin.math.sign

/**
 * leetcode - https://leetcode.com/problems/count-hills-and-valleys-in-an-array/
 *
 * Using single pass
 * [Int.sign] => return sign of an [Int] => -1, 0, or 1
 *
 * Stats
 * Runtime: 165 ms, faster than 50.00%
 * Memory Usage: 34.1 MB, less than 70.00%
 */
private fun countHillValley(nums: IntArray): Int {
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

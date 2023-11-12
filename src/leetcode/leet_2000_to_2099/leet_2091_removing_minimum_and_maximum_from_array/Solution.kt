package leetcode.leet_2000_to_2099.leet_2091_removing_minimum_and_maximum_from_array

import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/removing-minimum-and-maximum-from-array/
 *
 * Using iteration and conditionals
 *
 * Stats
 * Runtime: 517 ms, faster than 28.57%
 * Memory Usage: 52.2 MB, less than 14.29%
 */
private fun minimumDeletions(nums: IntArray): Int {
    if (nums.size < 2) {
        return nums.size
    }
    var minValue = nums[0]
    var minIndex = 0
    var maxValue = nums[0]
    var maxIndex = 0
    nums.forEachIndexed { index, num ->
        if (num < minValue) {
            minValue = num
            minIndex = index
        }
        if (num > maxValue) {
            maxValue = num
            maxIndex = index
        }
    }
    return minOf (
        max(minIndex, maxIndex) + 1,
        nums.size - min(minIndex, maxIndex),
        min(minIndex, maxIndex) + 1 + (nums.size - max(minIndex, maxIndex))
    )
}

private fun main() {

}

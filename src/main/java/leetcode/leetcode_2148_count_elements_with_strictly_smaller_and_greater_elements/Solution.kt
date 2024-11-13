package leetcode.leetcode_2148_count_elements_with_strictly_smaller_and_greater_elements

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/count-elements-with-strictly-smaller-and-greater-elements/
 *
 * Using max value, min value, max count and min count
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 16 ms, faster than 100.00%
 * Memory Usage: 37.6 MB, less than 60.00%
 *
 * Time -
 * Space -
 */
private fun countElements(nums: IntArray): Int {
    var maxValue = nums[0]
    var minValue = nums[0]
    var maxCount = 1
    var minCount = 1
    for (i in 1..nums.lastIndex) {
        if (nums[i] > maxValue) {
            maxValue = nums[i]
            maxCount = 1
        } else if (nums[i] == maxValue) {
            maxCount++
        }
        if (nums[i] < minValue) {
            minValue = nums[i]
            minCount = 1
        } else if (nums[i] == minValue) {
            minCount++
        }
    }
    return max(0, nums.size - maxCount - minCount)
}

/**
 * leetcode - https://leetcode.com/problems/count-elements-with-strictly-smaller-and-greater-elements/
 *
 * Using sorting and two pointer
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 18 ms, faster than 66.67%
 * Memory Usage: 37.6 MB, less than 60.00%
 *
 * Time -
 * Space -
 */
private fun countElementsUsingSorting(nums: IntArray): Int {
    nums.sort()
    var left = 0
    var right = nums.lastIndex
    while (left < nums.lastIndex && nums[left + 1] == nums[left]) {
        left++
    }
    while (right > 0 && nums[right - 1] == nums[right]) {
        right--
    }
    return if (left < right) {
        right - left - 1
    } else {
        0
    }
}

private fun main() {

}

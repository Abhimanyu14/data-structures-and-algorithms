package leetcode.leet_2300_to_2399.leet_2366_minimum_replacements_to_sort_the_array

import kotlin.math.ceil

/**
 * leetcode - https://leetcode.com/problems/minimum-replacements-to-sort-the-array/
 *
 * TODO(Abhi) - To revisit
 *
 * Using maths
 *
 * Stats
 * Runtime: 416 ms, faster than 12.50%
 * Memory Usage: 60.5 MB, less than 12.50%
 */
private fun minimumReplacement(nums: IntArray): Long {
    var result: Long = 0

    // Start from the second last element, as the last one is always sorted.
    for (i in nums.lastIndex - 1 downTo 0) {
        // No need to break if they are already in order.
        if (nums[i] <= nums[i + 1]) {
            continue
        }

        // Count how many elements are made from breaking nums[i].
        val numElements = ceil(nums[i].toDouble() / nums[i + 1].toDouble()).toInt()

        // It requires numElements - 1 replacement operations.
        result += numElements - 1

        // Maximize nums[i] after replacement.
        nums[i] = nums[i] / numElements
    }
    return result
}

private fun main() {

}

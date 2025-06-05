package leetcode.leetcode_1060_missing_element_in_sorted_array

/**
 * leetcode - https://leetcode.com/problems/missing-element-in-sorted-array/description/
 * Premium Question
 *
 * Data Structure - NA
 * Algorithm - Binary Search
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(log (N))
 * Space - O(1)
 *
 * Companies - Amazon, Google, Meta
 */
private fun missingElement(nums: IntArray, k: Int): Int {
    var left = 0
    var right = nums.size
    while (left < right) {
        val mid = left + (right - left) / 2
        if (nums[mid] >= nums[0] + mid + k) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return nums[0] + k + left - 1
}

/**
 * leetcode - https://leetcode.com/problems/missing-element-in-sorted-array/description/
 * Premium Question
 *
 * Data Structure - NA
 * Algorithm - Linear Search
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Amazon, Meta
 */
private fun missingElementUsingLinearSearch(nums: IntArray, k: Int): Int {
    var current = nums[0] + k
    var index = 1
    while (index <= nums.lastIndex && current >= nums[index]) {
        current++
        index++
    }
    return current
}

private fun main() {

}

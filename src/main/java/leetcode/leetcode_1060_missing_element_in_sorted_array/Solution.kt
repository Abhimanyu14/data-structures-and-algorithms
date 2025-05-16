package leetcode.leetcode_1060_missing_element_in_sorted_array

/**
 * leetcode - https://leetcode.com/problems/missing-element-in-sorted-array/description/
 * Premium Question
 *
 * Data Structure -
 * Algorithm - Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space - O(1)
 *
 * Companies - Amazon, Meta
 */
private fun missingElementUsingLinearSearch(nums: IntArray, k: Int): Int {
    var count = 0
    var current = nums[0] + 1
    var index = 1
    while (index <= nums.lastIndex) {
        if (nums[index] == current) {
            index++
        } else {
            count++
            if (count == k) {
                return current
            }
        }
        current++
    }
    return nums.last() + (k - count)
}

private fun main() {

}

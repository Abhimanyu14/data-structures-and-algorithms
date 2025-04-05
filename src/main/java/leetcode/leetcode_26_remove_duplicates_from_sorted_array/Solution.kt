package leetcode.leetcode_26_remove_duplicates_from_sorted_array

/**
 * leetcode - https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * Data Structure - NA
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 12 ms, faster than 14.10%
 * Memory Usage: 52.83 MB, less than 5.15%
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun removeDuplicates(nums: IntArray): Int {
    if (nums.size == 1) {
        return 1
    }
    var leftIndex = 1
    var rightIndex = 1
    while (rightIndex <= nums.lastIndex) {
        if (nums[leftIndex - 1] != nums[rightIndex]) {
            nums[leftIndex] = nums[rightIndex]
            leftIndex++
        }
        rightIndex++
    }
    return leftIndex
}

private fun main() {
    println(removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)))
}

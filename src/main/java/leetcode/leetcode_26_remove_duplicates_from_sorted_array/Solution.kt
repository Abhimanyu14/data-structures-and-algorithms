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
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Meta
 */
private fun removeDuplicates(nums: IntArray): Int {
    var insertIndex = 1
    var iterationIndex = 1
    while (iterationIndex <= nums.lastIndex) {
        if (nums[iterationIndex] != nums[insertIndex - 1]) {
            nums[insertIndex] = nums[iterationIndex]
            insertIndex++
        }
        iterationIndex++
    }
    return insertIndex
}

private fun main() {
    println(removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)))
}

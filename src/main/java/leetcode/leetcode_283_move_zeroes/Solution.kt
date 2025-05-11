package leetcode.leetcode_283_move_zeroes

/**
 * leetcode - https://leetcode.com/problems/move-zeroes/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Data Structure - [IntArray]
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Google, Meta, Microsoft
 */
private fun moveZeroes(nums: IntArray): Unit {
    var insertIndex = 0
    var currentIndex = 0
    while (currentIndex <= nums.lastIndex) {
        if (nums[currentIndex] != 0) {
            nums[insertIndex] = nums[currentIndex]
            insertIndex++
        }
        currentIndex++
    }
    while (insertIndex <= nums.lastIndex) {
        nums[insertIndex] = 0
        insertIndex++
    }
}

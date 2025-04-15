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
 * Companies - Google, Meta
 */
private fun moveZeroes(nums: IntArray): Unit {
    var left = 0
    for (i in 0..nums.lastIndex) {
        if (nums[i] != 0) {
            nums[left++] = nums[i]
        }
    }
    while (left <= nums.lastIndex) {
        nums[left++] = 0
    }
}

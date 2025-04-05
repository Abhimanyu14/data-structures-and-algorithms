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
 * Runtime: 564 ms, faster than 58.23%
 * Memory Usage: 65.2 MB, less than 17.84%
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Google, Meta
 */
private fun moveZeroes(nums: IntArray) {
    var leftIndex = 0
    var rightIndex = 0
    while (rightIndex <= nums.lastIndex) {
        if (nums[rightIndex] != 0) {
            nums[leftIndex] = nums[rightIndex]
            leftIndex++
        }
        rightIndex++
    }
    while (leftIndex <= nums.lastIndex) {
        nums[leftIndex] = 0
        leftIndex++
    }
}

private fun main() {
    val input = intArrayOf(0, 1, 0, 3, 12)
    moveZeroes(input)
    println(input.joinToString())
}

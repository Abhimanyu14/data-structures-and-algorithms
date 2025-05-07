package leetcode.leetcode_1920_build_array_from_permutation

/**
 * leetcode - https://leetcode.com/problems/build-array-from-permutation/
 *
 * Data Structure - [IntArray]
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Amazon, Meta, Google
 */
private fun buildArray(nums: IntArray): IntArray {
    return IntArray(nums.size) { nums[nums[it]] }
}

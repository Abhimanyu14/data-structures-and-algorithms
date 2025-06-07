package leetcode.leetcode_1493_longest_subarray_of_1s_after_deleting_one_element

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/?envType=company&envId=facebook&favoriteSlug=facebook-three-months
 *
 * Data Structure - NA
 * Algorithm - Iteration & counting
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private fun longestSubarray(nums: IntArray): Int {
    var prev = 0
    var current = 0
    var result = 0
    for (num in nums) {
        if (num == 1) {
            current++
        } else {
            prev = current
            current = 0
        }
        result = max(result, current + prev)
    }
    if (result == nums.size) {
        result--
    }
    return result
}

private fun main() {

}

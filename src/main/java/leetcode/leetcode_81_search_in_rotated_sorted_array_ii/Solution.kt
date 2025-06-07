package leetcode.leetcode_81_search_in_rotated_sorted_array_ii

/**
 * leetcode - https://leetcode.com/problems/search-in-rotated-sorted-array-ii/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days
 *
 * Data Structure - NA
 * Algorithm - LinearSearch
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
private fun searchUsingLinearSearch(nums: IntArray, target: Int): Boolean {
    for (num in nums) {
        if (num == target) {
            return true
        }
    }
    return false
}

private fun main() {

}

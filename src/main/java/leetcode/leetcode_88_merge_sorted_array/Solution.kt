package leetcode.leetcode_88_merge_sorted_array

/**
 * leetcode - https://leetcode.com/problems/merge-sorted-array/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Data Structure - Two Pointers
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 319 ms, faster than 36.53%
 * Memory Usage: 36.1 MB, less than 40.72%
 *
 * Time - O(M + N)
 * Space - O(1) - Input size not considered
 *
 * Companies - Meta
 */
private fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
    var index1 = m - 1
    var index2 = n - 1
    var current = m + n - 1
    while (index1 >= 0 && index2 >= 0) {
        if (nums1[index1] >= nums2[index2]) {
            nums1[current] = nums1[index1]
            index1--
        } else {
            nums1[current] = nums2[index2]
            index2--
        }
        current--
    }
    while (index1 >= 0) {
        nums1[current] = nums1[index1]
        index1--
        current--
    }
    while (index2 >= 0) {
        nums1[current] = nums2[index2]
        index2--
        current--
    }
}

private fun main() {

}

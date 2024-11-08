package leetcode.leetcode_3162_find_the_number_of_good_pairs_i

/**
 * leetcode - https://leetcode.com/problems/find-the-number-of-good-pairs-i/
 *
 * Using iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 2 ms, faster than 60.00%
 * Memory Usage: 40 MB, less than 5.56%
 *
 * Time - O(M * N)
 * Space - O(1)
 */
private fun numberOfPairs(nums1: IntArray, nums2: IntArray, k: Int): Int {
    var result = 0
    for (i in nums2.indices) {
        for (j in nums1.indices) {
            if (nums1[j] % (nums2[i] * k) == 0) {
                result++
            }
        }
    }
    return result
}

private fun main() {

}

package leetcode.leetcode_493_reverse_pairs

/**
 * leetcode - https://leetcode.com/problems/reverse-pairs/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm - Iteration
 *
 * Difficulty - Hard
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time - O(N ^ 2)
 * Space - O(1)
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private fun reversePairs(nums: IntArray): Int {
    var result = 0
    for (i in 0..(nums.lastIndex - 1)) {
        for (j in (i + 1)..nums.lastIndex) {
            if (nums[i].toLong() > nums[j].toLong() * 2) {
                result++
            }
        }
    }
    return result
}

private fun main() {

}

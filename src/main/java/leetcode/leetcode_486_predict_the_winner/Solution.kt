package leetcode.leetcode_486_predict_the_winner

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/predict-the-winner/description/?envType=problem-list-v2&envId=2c815prs
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - NA
 * Algorithm - Recursion
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N^N)
 * Space - O(N)
 *
 * Companies - Amazon, Apple, Google, Microsoft
 */
private fun predictTheWinner(nums: IntArray): Boolean {
    val dp = nums.copyOf(nums.size)
    for (diff in 1..<nums.size) {
        for (left in 0..<nums.size - diff) {
            dp[left] = max((nums[left] - dp[left + 1]), (nums[left + diff] - dp[left]))
        }
    }
    return dp[0] >= 0
}

/**
 * leetcode - https://leetcode.com/problems/predict-the-winner/description/?envType=problem-list-v2&envId=2c815prs
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - NA
 * Algorithm - Recursion
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N^N)
 * Space - O(N^N)
 *
 * Companies - Amazon, Apple, Google, Microsoft
 */
private fun predictTheWinnerUsing2DArray(nums: IntArray): Boolean {
    val cache = Array(nums.size) { arrayOfNulls<Int>(nums.size) }
    fun maxDiff(start: Int, end: Int): Int {
        if (start > end) {
            return 0
        }
        cache[start][end]?.let {
            return it
        }
        cache[start][end] = max(nums[start] - maxDiff(start + 1, end), nums[end] - maxDiff(start, end - 1))
        return cache[start][end]!!
    }
    return maxDiff(0, nums.lastIndex) >= 0
}

/**
 * leetcode - https://leetcode.com/problems/predict-the-winner/description/?envType=problem-list-v2&envId=2c815prs
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - NA
 * Algorithm - Recursion
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(2^N)
 * Space - O(N)
 *
 * Companies - Amazon, Apple, Google, Microsoft
 */
private fun predictTheWinnerUsingBruteForce(nums: IntArray): Boolean {
    fun maxDiff(start: Int, end: Int): Int {
        if (start > end) {
            return 0
        }
        return max(nums[start] - maxDiff(start + 1, end), nums[end] - maxDiff(start, end - 1))
    }
    return maxDiff(0, nums.lastIndex) >= 0
}

private fun main() {

}

package leetcode.leetcode_300_longest_increasing_subsequence

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/longest-increasing-subsequence/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - NA
 * Algorithm - Recursion
 *
 * Source - https://youtu.be/cjWnW0hdF1Y
 *
 * Difficulty - Medium
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time - O(N^2)
 * Space - O(N)
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private fun lengthOfLIS(nums: IntArray): Int {
    val list = mutableListOf<Int>()
    list.add(nums[0])

    fun findIndex(x: Int): Int {
        var left = 0
        var right = list.size
        while (left < right) {
            val mid = left + (right - left) / 2
            if (list[mid] >= x) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left
    }

    for (i in 1..nums.lastIndex) {
        if (nums[i] > list.last()) {
            list.add(nums[i])
        } else {
            val index = findIndex(nums[i])
            list[index] = nums[i]
        }
    }

    return list.size
}

/**
 * leetcode - https://leetcode.com/problems/longest-increasing-subsequence/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - NA
 * Algorithm - Recursion
 *
 * Source - https://youtu.be/cjWnW0hdF1Y
 *
 * Difficulty - Medium
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time - O(N^2)
 * Space - O(N)
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private fun lengthOfLISUsingDp(nums: IntArray): Int {
    var result = 1
    val dp = IntArray(nums.size) { 1 }
    for (i in (nums.lastIndex - 1) downTo 0) {
        for (j in (i + 1)..nums.lastIndex) {
            if (nums[i] < nums[j]) {
                dp[i] = max(dp[i], 1 + dp[j])
                result = max(result, dp[i])
            }
        }
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/longest-increasing-subsequence/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - NA
 * Algorithm - Recursion
 *
 * Difficulty - Medium
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time - O(2^N)
 * Space - O(N)
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private fun lengthOfLISUsingRecursion(nums: IntArray): Int {
    fun lengthOfLIS(index: Int, lastValue: Int): Int {
        if (index > nums.lastIndex) {
            return 0
        }
        return if (nums[index] > lastValue) {
            max(lengthOfLIS(index + 1, lastValue), lengthOfLIS(index + 1, nums[index]) + 1)
        } else {
            lengthOfLIS(index + 1, lastValue)
        }
    }
    return lengthOfLIS(0, Int.MIN_VALUE)
}

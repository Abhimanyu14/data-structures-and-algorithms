package leetcode.leetcode_198_house_robber

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/house-robber/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Using two pointers
 *
 * Stats
 * Runtime: 156 ms, faster than 89.86%
 * Memory Usage: 35.5 MB, less than 28.49%
 */
private fun rob(nums: IntArray): Int {
    if (nums.size == 1) {
        return nums[0]
    }
    var prev = 0
    var current = 0
    var temp: Int
    for (i in 0..nums.lastIndex) {
        temp = current
        current = max(current, prev + nums[i])
        prev = temp
    }
    return current
}

/**
 * leetcode - https://leetcode.com/problems/house-robber/
 *
 * Using DP - dynamic programming
 *
 * Stats
 * Runtime: 167 ms, faster than 84.11%
 * Memory Usage: 35.4 MB, less than 28.49%
 */
private fun robUsingDp(nums: IntArray): Int {
    if (nums.size == 1) {
        return nums[0]
    }
    val dp = IntArray(nums.size)
    dp[0] = nums[0]
    dp[1] = max(nums[0], nums[1])
    for (i in 2..nums.lastIndex) {
        dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
    }
    return dp[nums.lastIndex]
}

private fun main() {

}

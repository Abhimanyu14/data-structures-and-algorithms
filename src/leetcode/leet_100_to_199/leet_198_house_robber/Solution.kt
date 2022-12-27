package leetcode.leet_100_to_199.leet_198_house_robber

import kotlin.math.max

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

/**
 * leetcode - https://leetcode.com/problems/house-robber/
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
    var dpBeforePrev = nums[0]
    var dpPrev = max(nums[0], nums[1])
    var current = dpPrev
    for (i in 2..nums.lastIndex) {
        current = max(dpPrev, dpBeforePrev + nums[i])
        dpBeforePrev = dpPrev
        dpPrev = current
    }
    return current
}

private fun main() {

}

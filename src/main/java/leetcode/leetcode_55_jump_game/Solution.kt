package leetcode.leetcode_55_jump_game

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/jump-game-ii/
 *
 * Data Structure - NA
 * Algorithm - Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Meta
 */
private fun canJump(nums: IntArray): Boolean {
    var reach = 0
    for (i in nums.indices) {
        if (i > reach) {
            break
        }
        reach = max(reach, nums[i] + i)
    }
    return reach >= nums.lastIndex
}

/**
 * leetcode - https://leetcode.com/problems/jump-game-ii/
 *
 * Using solution of leetcode 45 (https://leetcode.com/problems/jump-game-ii/)
 *
 * Stats
 * Runtime: 346 ms, faster than 92.73%
 * Memory Usage: 40.3 MB, less than 87.61%
 *
 * Time -
 * Space -
 */
private fun canJumpUsingSolution45(nums: IntArray): Boolean {
    var i = 0
    var j: Int
    var max: Int
    var maxPos: Int
    while (i < nums.lastIndex) {
        if (nums[i] == 0) {
            return false
        }
        maxPos = i + nums[i]
        if (maxPos >= nums.lastIndex) {
            break
        }
        max = nums[maxPos]
        j = maxPos - 1
        while (j > i) {
            if (max < (nums[j] - (i + nums[i] - j))) {
                max = nums[j] - (i + nums[i] - j)
                maxPos = j
            }
            j--
        }
        i = maxPos
    }
    return true
}

/**
 * leetcode - https://leetcode.com/problems/jump-game-ii/
 *
 * Using dynamic programming - tabulation
 *
 * Stats
 * Runtime: 967 ms, faster than 6.01%
 * Memory Usage: 43.5 MB, less than 8.60%
 *
 * Time -
 * Space -
 */
private fun canJumpUsingDp(nums: IntArray): Boolean {
    val dp = BooleanArray(nums.size)
    dp[0] = true
    for (i in 0..<nums.lastIndex) {
        if (dp[i]) {
            repeat(nums[i]) {
                if (i + it + 1 <= nums.lastIndex) {
                    dp[i + it + 1] = true
                }
            }
        }
    }
    return dp[nums.lastIndex]
}

private fun main() {

}

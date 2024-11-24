package leetcode.leetcode_45_jump_game_ii

import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/jump-game-ii/
 *
 * TODO(Abhi) - To revisit
 *
 * Using range, greedy
 *
 * Source - https://youtu.be/7SBVnw7GSTk?si=ubJ3yuMZSw9n26w2
 *
 * Stats
 * Runtime: 18 ms, faster than 46.07%
 * Memory Usage: 41.3 MB, less than 13.26%
 *
 * Time -
 * Space -
 */
private fun jump(nums: IntArray): Int {
    var result = 0
    var left = 0
    var right = 0
    while (right < nums.lastIndex) {
        var farthestPosition = 0
        for (i in left..right) {
            farthestPosition = max(farthestPosition, i + nums[i])
        }
        left = right + 1
        right = farthestPosition
        result++
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/jump-game-ii/
 *
 * Using greedy
 *
 * Stats
 * Runtime: 242 ms, faster than 88.61%
 * Memory Usage: 38.6 MB, less than 81.65%
 *
 * Time -
 * Space -
 */
private fun jumpUsingGreedy(nums: IntArray): Int {
    var result = 0
    var i = 0
    var j: Int
    var max: Int
    var maxPos: Int
    while (i < nums.lastIndex) {
        maxPos = i + nums[i]
        if (maxPos >= nums.lastIndex) {
            result++
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
        result++
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/jump-game-ii/
 *
 * Using dynamic programming - tabulation
 *
 * Stats
 * Runtime: 70 ms, faster than 20.79%
 * Memory Usage: 40.4 MB, less than 27.07%
 *
 * Time -
 * Space -
 */
private fun jumpUsingDp(nums: IntArray): Int {
    val dp = IntArray(nums.size) { Int.MAX_VALUE }
    dp[0] = 0
    nums.forEachIndexed { i, num ->
        for (j in 1..num) {
            if (i + j < nums.size) {
                dp[i + j] = min(dp[i + j], dp[i] + 1)
            }
        }
    }
    return dp[nums.lastIndex]
}

private fun main() {
}

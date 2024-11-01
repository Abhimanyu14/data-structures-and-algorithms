package leetcode.leetcode_213_house_robber_ii

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/house-robber-ii/
 *
 * Using two pointer
 *
 * Stats
 * Runtime: 143 ms, faster than 65.74%
 * Memory Usage: 37.1 MB, less than 32.41%
 */
private fun rob(nums: IntArray): Int {
    if (nums.size == 1) {
        return nums[0]
    }

    fun simpleRob(start: Int, end: Int): Int {
        var prev = 0
        var current = 0
        var temp: Int
        for (i in start..end) {
            temp = current
            current = max(current, prev + nums[i])
            prev = temp
        }
        return current
    }
    return max(simpleRob(0, nums.lastIndex - 1), simpleRob(1, nums.lastIndex))
}

private fun main() {

}

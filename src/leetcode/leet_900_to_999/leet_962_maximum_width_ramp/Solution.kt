package leetcode.leet_900_to_999.leet_962_maximum_width_ramp

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/maximum-width-ramp/
 *
 * TODO(Abhi) - To revisit
 *
 * Using recursion
 *
 * Stats
 * Time Limit Exceeded
 */
private fun maxWidthRamp(nums: IntArray): Int {
    val memo = mutableMapOf<Pair<Int, Int>, Int>()
    fun findMax(start: Int, end: Int): Int {
        memo[Pair(start, end)]?.let {
            return it
        }
        if (nums[start] <= nums[end]) {
            memo[Pair(start, end)] = end - start
            return memo[Pair(start, end)] ?: 0
        }
        memo[Pair(start, end)] = max(findMax(start + 1, end), findMax(start, end - 1))
        return memo[Pair(start, end)] ?: 0
    }
    return findMax(0, nums.lastIndex)
}

private fun main() {

}

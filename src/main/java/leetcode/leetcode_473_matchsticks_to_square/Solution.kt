package leetcode.leetcode_473_matchsticks_to_square

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/matchsticks-to-square/description/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [BooleanArray],
 * Algorithm - Backtracking (Recursion)
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(2^N)
 * Space - O(N)
 *
 * Companies - Meta, Microsoft
 */
private fun makesquare(matchsticks: IntArray): Boolean {
    var sumValue = 0
    var maxValue = 0
    for (matchstick in matchsticks) {
        sumValue += matchstick
        maxValue = max(maxValue, matchstick)
    }
    if (sumValue % 4 != 0) {
        return false
    }
    val sideLength = sumValue / 4
    if (maxValue > sideLength) {
        return false
    }
    val isUsed = BooleanArray(matchsticks.size)
    fun backtrack(index: Int, remaining: Int, currentSum: Int): Boolean {
        if (remaining == 0) {
            return true
        }
        if (currentSum == sideLength) {
            return backtrack(0, remaining - 1, 0)
        }
        if (index == matchsticks.size) {
            return false
        }
        if (!isUsed[index] && (matchsticks[index] + currentSum <= sideLength)) {
            isUsed[index] = true
            if (backtrack(index + 1, remaining, matchsticks[index] + currentSum)) {
                return true
            }
            isUsed[index] = false
        }
        return backtrack(index + 1, remaining, currentSum)
    }
    return backtrack(0, 4, 0)
}

private fun main() {

}

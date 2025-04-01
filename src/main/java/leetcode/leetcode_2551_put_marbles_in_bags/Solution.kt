package leetcode.leetcode_2551_put_marbles_in_bags

import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/put-marbles-in-bags/description/?envType=daily-question&envId=2025-03-31
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - NA
 * Algorithm - Recursion (Permutation)
 *
 * Difficulty - Hard
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time -
 * Space -
 *
 * Companies - Amazon, Apple, TikTok, Uber
 */


/**
 * leetcode - https://leetcode.com/problems/put-marbles-in-bags/description/?envType=daily-question&envId=2025-03-31
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - NA
 * Algorithm - Recursion (Permutation)
 *
 * Difficulty - Hard
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time -
 * Space -
 *
 * Companies - Amazon, Apple, TikTok, Uber
 */
private fun putMarblesUsingExponentialSolution(weights: IntArray, k: Int): Long {
    if (weights.size == k) {
        return 0
    }
    var maxValue = Long.MIN_VALUE
    var minValue = Long.MAX_VALUE
    fun calculateScores(index: Int, remaining: Int, scoreSoFar: Long) {
        if (remaining == 1) {
            maxValue = max(maxValue, scoreSoFar + weights[index] + weights.last())
            minValue = min(minValue, scoreSoFar + weights[index] + weights.last())
            return
        }
        for (i in 1..((weights.lastIndex - index + 1) - (remaining - 1))) {
            calculateScores(index + i, remaining - 1, scoreSoFar + weights[index] + weights[index + i - 1])
        }
    }
    calculateScores(0, k, 0L)
    return maxValue - minValue
}

private fun main() {

}

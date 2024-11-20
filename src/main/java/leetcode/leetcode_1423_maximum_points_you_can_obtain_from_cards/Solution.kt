package leetcode.leetcode_1423_maximum_points_you_can_obtain_from_cards

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 *
 * Using sliding window
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 20 ms, faster than 50.00%
 * Memory Usage: 51.1 MB, less than 82.35%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun maxScore(cardPoints: IntArray, k: Int): Int {
    var result = 0
    var current = 0
    var index = 0
    while (index < k) {
        result += cardPoints[index]
        index++
    }
    current = result
    while (index > 0) {
        current -= cardPoints[index - 1]
        current += cardPoints[cardPoints.lastIndex - (k - index)]
        result = max(result, current)
        index--
    }
    return result
}

private fun main() {

}

package leetcode.leetcode_1423_maximum_points_you_can_obtain_from_cards

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 *
 * Data Structure - NA
 * Algorithm - Sliding Window
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 21 ms, faster than 34.78%
 * Memory Usage: 51.6 MB, less than 37.50%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun maxScore(cardPoints: IntArray, k: Int): Int {
    var result: Int
    var totalSum = 0
    var currentWindowSum = 0
    for (i in cardPoints.indices) {
        totalSum += cardPoints[i]
        if (i == cardPoints.lastIndex - k) {
            currentWindowSum = cardPoints[i]
        }
    }
    result = totalSum - currentWindowSum
    repeat(k) {
        currentWindowSum = currentWindowSum - cardPoints[it] + cardPoints[cardPoints.size - k + it]
        result = max(result, totalSum - currentWindowSum)
    }
    return result
}

private fun main() {

}


/*

[-2,-1,-3,-6,4]
[1,1,1,1,1,5,5]
[6,-31,50,-35,41,37,-42,13]*/

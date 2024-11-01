package leetcode.leetcode_900_to_999.leetcode_948_bag_of_tokens

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/bag-of-tokens/?envType=daily-question&envId=2024-03-04
 *
 * Using sorting and two pointer
 *
 * Stats
 * Runtime: 186 ms, faster than 60.00%
 * Memory Usage: 38.7 MB, less than 60.00%
 */
private fun bagOfTokensScore(tokens: IntArray, power: Int): Int {
    tokens.sort()
    var result = 0
    var currentScore = 0
    var currentPower = power
    var low = 0
    var high = tokens.lastIndex
    while (high >= low) {
        if (currentPower >= tokens[low]) {
            currentScore++
            currentPower -= tokens[low]
            result = max(result, currentScore)
            low++
        } else if (currentScore > 0) {
            currentScore--
            currentPower += tokens[high]
            high--
        } else {
            return currentScore
        }
    }
    return result
}

private fun main() {

}

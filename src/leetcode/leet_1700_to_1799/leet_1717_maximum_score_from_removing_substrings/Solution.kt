package leetcode.leet_1700_to_1799.leet_1717_maximum_score_from_removing_substrings

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/maximum-score-from-removing-substrings/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun maximumGain(s: String, x: Int, y: Int): Int {
    // Ensure "ab" always has higher points than "ba"
    var s = s
    var x = x
    var y = y
    if (x < y) {
        // Swap points
        val temp = x
        x = y
        y = temp
        // Reverse the string to maintain logic
        s = StringBuilder(s).reverse().toString()
    }

    var aCount = 0
    var bCount = 0
    var totalPoints = 0

    for (element in s) {
        if (element == 'a') {
            aCount++
        } else if (element == 'b') {
            if (aCount > 0) {
                // Can form "ab", remove it and add points
                aCount--
                totalPoints += x
            } else {
                // Can't form "ab", keep 'b' for potential future "ba"
                bCount++
            }
        } else {
            // Non 'a' or 'b' character encountered
            // Calculate points for any remaining "ba" pairs
            totalPoints += (min(bCount, aCount) * y)
            // Reset counters for next segment
            bCount = 0
            aCount = 0
        }
    }

    // Calculate points for any remaining "ba" pairs at the end
    totalPoints += min(bCount, aCount) * y

    return totalPoints
}

private fun main() {

}

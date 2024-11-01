package leetcode.leetcode_800_to_899.leetcode_861_score_after_flipping_matrix

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/score-after-flipping-matrix/?envType=daily-question&envId=2024-05-13
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 150 ms, faster than 50.00%
 * Memory Usage: 34 MB, less than 100.00%
 *
 * Time -
 * Space -
 */
private fun matrixScore(grid: Array<IntArray>): Int {
    // Set score to summation of first column
    var score = (1 shl (grid[0].size - 1)) * grid.size

    // Loop over all other columns
    for (j in 1..<grid[0].size) {
        var countSameBits = 0
        for (i in grid.indices) {
            // Count elements matching first in row
            if (grid[i][j] == grid[i][0]) {
                countSameBits++
            }
        }
        // Calculate score based on the number of same bits in a column
        countSameBits = max(countSameBits.toDouble(), (grid.size - countSameBits).toDouble()).toInt()
        // Calculate the score contribution for the current column
        val columnScore = (1 shl (grid[0].size - j - 1)) * countSameBits
        // Add contribution to score
        score += columnScore
    }

    return score
}

private fun main() {

}

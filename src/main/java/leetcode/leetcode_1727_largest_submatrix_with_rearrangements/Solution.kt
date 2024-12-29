package leetcode.leetcode_1727_largest_submatrix_with_rearrangements

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/largest-submatrix-with-rearrangements/
 *
 * Using no sort
 *
 * Stats
 * Runtime: 582 ms, faster than 75.00%
 * Memory Usage: 84.2 MB, less than 25.00%
 */
private fun largestSubmatrix(matrix: Array<IntArray>): Int {
    var result = 0
    var prevHeights = mutableListOf<Pair<Int, Int>>()
    for (row in matrix.indices) {
        val heights = mutableListOf<Pair<Int, Int>>()
        val seen = BooleanArray(matrix[0].size)
        for (pair in prevHeights) {
            val height: Int = pair.first
            val col: Int = pair.second
            if (matrix[row][col] == 1) {
                heights.add(Pair(height + 1, col))
                seen[col] = true
            }
        }
        for (col in 0..<matrix[0].size) {
            if (!seen[col] && matrix[row][col] == 1) {
                heights.add(Pair(1, col))
            }
        }
        for (i in heights.indices) {
            result = max(result, heights[i].first * (i + 1))
        }
        prevHeights = heights
    }
    return result
}

private fun main() {

}

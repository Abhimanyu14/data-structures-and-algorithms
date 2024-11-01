package leetcode.leetcode_2300_to_2399.leetcode_2373_largest_local_values_in_a_matrix

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/largest-local-values-in-a-matrix/?envType=daily-question&envId=2024-05-12
 *
 * Using
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 225 ms, faster than 100.00%
 * Memory Usage: 39.4 MB, less than 64.71%
 *
 * Time -
 * Space -
 */
// Return the maximum values in the 3 x 3 matrix with top-left as (x, y).
private fun largestLocal(grid: Array<IntArray>): Array<IntArray> {
    fun findMax(grid: Array<IntArray>, x: Int, y: Int): Int {
        var maxElement = 0
        for (i in x..<x + 3) {
            for (j in y..<y + 3) {
                maxElement = max(maxElement, grid[i][j])
            }
        }
        return maxElement
    }
    val maxLocal = Array(grid.size - 2) { IntArray(grid.size - 2) }
    for (i in 0..<grid.size - 2) {
        for (j in 0..<grid.size - 2) {
            maxLocal[i][j] = findMax(grid, i, j)
        }
    }
    return maxLocal
}

private fun main() {

}

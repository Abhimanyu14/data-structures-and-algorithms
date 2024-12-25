package leetcode.leetcode_892_surface_area_of_3d_shapes

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/surface-area-of-3d-shapes/
 *
 * Data Structure -
 * Algorithm - Iteration and Counting
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 7 ms, faster than 100.00%
 * Memory Usage: 38.5 MB, less than 100.00%
 *
 * Time -
 * Space -
 */
private     fun surfaceArea(grid: Array<IntArray>): Int {
    val n = grid.size
    var result = 2 * n * n
    for (i in 0..<n) {
        result += grid[0][i] + grid[n - 1][i] + grid[i][0] + grid[i][n - 1]
    }
    for (i in 0..<n) {
        for (j in 0..<n) {
            if (grid[i][j] == 0) {
                result -= 2
            } else {
                if (i > 0) {
                    result += max(0, grid[i][j] - grid[i - 1][j])
                }
                if (i < n - 1) {
                    result += max(0, grid[i][j] - grid[i + 1][j])
                }
                if (j > 0) {
                    result += max(0, grid[i][j] - grid[i][j - 1])
                }
                if (j < n - 1) {
                    result += max(0, grid[i][j] - grid[i][j + 1])
                }
            }
        }
    }
    return result
}

private fun main() {

}

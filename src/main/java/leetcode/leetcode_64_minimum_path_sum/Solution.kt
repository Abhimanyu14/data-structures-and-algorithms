package leetcode.leetcode_64_minimum_path_sum

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/minimum-path-sum/
 *
 * Using dynamic programming - optimized tabulation
 *
 * Stats
 * Runtime: 185 ms, faster than 61.54%
 * Memory Usage: 41.1 MB, less than 21.37%
 */
private fun minPathSum(grid: Array<IntArray>): Int {
    val result = IntArray(grid[0].size)
    result[0] = grid[0][0]
    for (i in 1..<grid[0].size) {
        result[i] = result[i - 1] + grid[0][i]
    }

    for (i in 1..<grid.size) {
        result[0] += grid[i][0]
        for (j in 1..<grid[0].size) {
            result[j] = min(result[j - 1], result[j]) + grid[i][j]
        }
    }
    return result.last()
}
private fun main() {

}

package leetcode.leetcode_3402_minimum_operations_to_make_columns_strictly_increasing

/**
 * leetcode - https://leetcode.com/problems/minimum-operations-to-make-columns-strictly-increasing/
 *
 * Data Structure - NA
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * 18 ms Beats 3.33%
 * 39.24 MB Beats 93.33%
 *
 * Time -
 * Space -
 */
private fun minimumOperations(grid: Array<IntArray>): Int {
    var result = 0
    var current: Int
    for (j in grid[0].indices) {
        current = grid[0][j]
        for (i in 1..grid.lastIndex) {
            if (grid[i][j] >= current + 1) {
                current = grid[i][j]
            } else {
                current++
                result += current - grid[i][j]
            }
        }
    }
    return result
}

private fun main() {

}

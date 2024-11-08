package leetcode.leetcode_1476_subrectangle_queries

/**
 * leetcode - https://leetcode.com/problems/subrectangle-queries/
 *
 * Using iteration
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 315 ms, faster than 66.67%
 * Memory Usage: 43.2 MB, less than 81.82%
 *
 * Time -
 * Space -
 */
private class SubrectangleQueries(rectangle: Array<IntArray>) {
    private val grid = rectangle.clone()
    fun updateSubrectangle(row1: Int, col1: Int, row2: Int, col2: Int, newValue: Int) {
        for (i in row1..row2) {
            for (j in col1..col2) {
                grid[i][j] = newValue
            }
        }
    }

    fun getValue(row: Int, col: Int): Int {
        return grid[row][col]
    }
}

private fun main() {

}

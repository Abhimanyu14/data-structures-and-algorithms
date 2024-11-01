package leetcode.leetcode_900_to_999.leetcode_980_unique_paths_iii

/**
 * leetcode - https://leetcode.com/problems/unique-paths-iii/
 *
 * Using backtracking
 *
 * Stats
 * Runtime: 161 ms, faster than 100.00%
 * Memory Usage: 34.8 MB, less than 85.00%
 */
private fun uniquePathsIII(grid: Array<IntArray>): Int {
    var result = 0
    fun backtrack(row: Int, col: Int, squaresLeft: Int) {
        var squaresToVisit = squaresLeft
        if (grid[row][col] == 2 && squaresToVisit == 1) {
            result++
            return
        }
        val temp = grid[row][col]
        grid[row][col] = -4
        squaresToVisit--
        val rowOffsets = intArrayOf(0, 0, 1, -1)
        val colOffsets = intArrayOf(1, -1, 0, 0)
        for (i in 0..3) {
            val nextRow = row + rowOffsets[i]
            val nextCol = col + colOffsets[i]
            if (nextRow < 0 || nextRow >= grid.size || nextCol < 0 || nextCol >= grid[0].size) {
                continue
            }
            if (grid[nextRow][nextCol] < 0) {
                continue
            }
            backtrack(nextRow, nextCol, squaresToVisit)
        }
        grid[row][col] = temp
    }

    var nonObstacles = 0
    var startRow = 0
    var startCol = 0
    grid.forEachIndexed { row, rowItems ->
        rowItems.forEachIndexed { col, cell ->
            if (cell >= 0) {
                nonObstacles++
            }
            if (cell == 1) {
                startRow = row
                startCol = col
            }
        }
    }
    backtrack(startRow, startCol, nonObstacles)
    return result
}

private fun main() {

}

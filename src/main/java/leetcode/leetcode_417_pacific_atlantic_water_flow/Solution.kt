package leetcode.leetcode_417_pacific_atlantic_water_flow

/**
 * leetcode - https://leetcode.com/problems/pacific-atlantic-water-flow/
 *
 * Using DFS
 *
 * Stats
 * Runtime: 311 ms, faster than 90.12%
 * Memory Usage: 44.1 MB, less than 59.26%
 */
private fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
    val rows = heights.size
    val cols = heights[0].size
    val pacificGrid = Array(rows) { Array(cols) { false } }
    val atlanticGrid = Array(rows) { Array(cols) { false } }

    fun dfs(row: Int, col: Int, grid: Array<Array<Boolean>>) {
        if (grid[row][col]) {
            return
        }
        grid[row][col] = true
        if (row > 0 && heights[row - 1][col] >= heights[row][col] && !grid[row - 1][col]) {
            dfs(row - 1, col, grid)
        }
        if (row < rows - 1 && heights[row + 1][col] >= heights[row][col] && !grid[row + 1][col]) {
            dfs(row + 1, col, grid)
        }
        if (col > 0 && heights[row][col - 1] >= heights[row][col] && !grid[row][col - 1]) {
            dfs(row, col - 1, grid)
        }
        if (col < cols - 1 && heights[row][col + 1] >= heights[row][col] && !grid[row][col + 1]) {
            dfs(row, col + 1, grid)
        }
    }
    for (i in 0..<rows) {
        dfs(i, 0, pacificGrid)
        dfs(i, cols - 1, atlanticGrid)
    }
    for (i in 0..<cols) {
        dfs(0, i, pacificGrid)
        dfs(rows - 1, i, atlanticGrid)
    }
    val result = mutableListOf<List<Int>>()
    for (i in heights.indices) {
        for (j in heights[0].indices) {
            if (pacificGrid[i][j] && atlanticGrid[i][j]) {
                result.add(listOf(i, j))
            }
        }
    }
    return result
}

private fun main() {

}

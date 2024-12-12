package leetcode.leetcode_417_pacific_atlantic_water_flow

/**
 * leetcode - https://leetcode.com/problems/pacific-atlantic-water-flow/
 * https://leetcode.com/problems/pacific-atlantic-water-flow/description/?envType=company&envId=google&favoriteSlug=google-thirty-days&difficulty=MEDIUM
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Graph
 * Algorithm - DFS
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 311 ms, faster than 90.12%
 * Memory Usage: 44.1 MB, less than 59.26%
 *
 * Time -
 * Space -
 */
private fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
    val pacificGrid = Array(heights.size) {
        Array(heights[0].size) {
            false
        }
    }
    val atlanticGrid = Array(heights.size) {
        Array(heights[0].size) {
            false
        }
    }

    fun dfs(row: Int, col: Int, grid: Array<Array<Boolean>>) {
        if (grid[row][col]) {
            return
        }
        grid[row][col] = true
        if (row > 0 && heights[row - 1][col] >= heights[row][col] && !grid[row - 1][col]) {
            dfs(row - 1, col, grid)
        }
        if (row < heights.lastIndex && heights[row + 1][col] >= heights[row][col] && !grid[row + 1][col]) {
            dfs(row + 1, col, grid)
        }
        if (col > 0 && heights[row][col - 1] >= heights[row][col] && !grid[row][col - 1]) {
            dfs(row, col - 1, grid)
        }
        if (col < heights[0].lastIndex && heights[row][col + 1] >= heights[row][col] && !grid[row][col + 1]) {
            dfs(row, col + 1, grid)
        }
    }
    for (i in heights.indices) {
        dfs(i, 0, pacificGrid)
        dfs(i, heights[0].lastIndex, atlanticGrid)
    }
    for (i in heights[0].indices) {
        dfs(0, i, pacificGrid)
        dfs(heights.lastIndex, i, atlanticGrid)
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

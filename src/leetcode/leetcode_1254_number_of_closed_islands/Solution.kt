package leetcode.leetcode_1254_number_of_closed_islands

/**
 * leetcode - https://leetcode.com/problems/number-of-closed-islands/
 *
 * Using DFS
 *
 * Stats
 * Runtime: 175 ms, faster than 88.46%
 * Memory Usage: 38.9 MB, less than 57.69%
 */
private fun closedIsland(grid: Array<IntArray>): Int {
    var result = 0
    val visited = Array(grid.size) { Array(grid[0].size) { false } }

    fun dfs(x: Int, y: Int): Boolean {
        visited[x][y] = true
        return if (grid[x][y] == 1) {
            false
        } else {
            var returnValue = true
            if (x - 1 >= 0 && grid[x - 1][y] == 0 && !visited[x - 1][y]) {
                if (!dfs(x - 1, y)) {
                    returnValue = false
                }
            }
            if (y - 1 >= 0 && grid[x][y - 1] == 0 && !visited[x][y - 1]) {
                if (!dfs(x, y - 1)) {
                    returnValue = false
                }
            }
            if (x + 1 < grid.size && grid[x + 1][y] == 0 && !visited[x + 1][y]) {
                if (!dfs(x + 1, y)) {
                    returnValue = false
                }
            }
            if (y + 1 < grid[0].size && grid[x][y + 1] == 0 && !visited[x][y + 1]) {
                if (!dfs(x, y + 1)) {
                    returnValue = false
                }
            }
            if (x == 0 || y == 0 || x + 1 == grid.size || y + 1 == grid[0].size) {
                returnValue = false
            }
            returnValue
        }
    }

    repeat(grid.size) { row ->
        repeat(grid[0].size) { col ->
            if (!visited[row][col] && dfs(row, col)) {
                result++
            }
        }
    }
    return result
}

private fun main() {

}

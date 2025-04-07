package leetcode.leetcode_695_max_area_of_island

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/max-area-of-island/
 *
 * Data Structure - [Array]
 * Algorithm - DFS
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Meta
 */
private fun maxAreaOfIsland(grid: Array<IntArray>): Int {
    val visited = Array(grid.size) { Array(grid[0].size) { false } }
    var result = 0
    fun getArea(row: Int, col: Int): Int {
        visited[row][col] = true
        var currentArea = 1

        if (row > 0 && grid[row - 1][col] == 1 && !visited[row - 1][col]) {
            currentArea += getArea(row - 1, col)
        }
        if (row < grid.lastIndex && grid[row + 1][col] == 1 && !visited[row + 1][col]) {
            currentArea += getArea(row + 1, col)
        }
        if (col > 0 && grid[row][col - 1] == 1 && !visited[row][col - 1]) {
            currentArea += getArea(row, col - 1)
        }
        if (col < grid[0].lastIndex && grid[row][col + 1] == 1 && !visited[row][col + 1]) {
            currentArea += getArea(row, col + 1)
        }
        return currentArea
    }

    grid.forEachIndexed { row, items ->
        items.forEachIndexed { col, item ->
            if (item == 1 && !visited[row][col]) {
                result = max(result, getArea(row, col))
            }
        }
    }
    return result
}

private fun main() {

}

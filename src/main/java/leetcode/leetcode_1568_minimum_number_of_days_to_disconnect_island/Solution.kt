package leetcode.leetcode_1568_minimum_number_of_days_to_disconnect_island

import java.util.Arrays
import kotlin.math.min


/**
 * leetcode - https://leetcode.com/problems/minimum-number-of-days-to-disconnect-island/?envType=daily-question&envId=2024-08-11
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty -
 *
 * Stats
 *
 * Time -
 * Space -
 */
private class Solution {
    fun minDays(grid: Array<IntArray>): Int {
        val rows = grid.size
        val cols = grid[0].size
        val apInfo = ArticulationPointInfo(false, 0)
        var landCells = 0
        var islandCount = 0

        // Arrays to store information for each cell
        val discoveryTime = Array(rows) { IntArray(cols) } // Time when a cell is first discovered
        val lowestReachable =
            Array(rows) { IntArray(cols) } // Lowest discovery time reachable from the subtree rooted at
        // this cell
        val parentCell = Array(rows) { IntArray(cols) } // Parent of each cell in DFS tree

        // Initialize arrays with default values
        for (i in 0..<rows) {
            Arrays.fill(discoveryTime[i], -1)
            Arrays.fill(lowestReachable[i], -1)
            Arrays.fill(parentCell[i], -1)
        }

        // Traverse the grid to find islands and articulation points
        for (i in 0..<rows) {
            for (j in 0..<cols) {
                if (grid[i][j] == 1) {
                    landCells++
                    if (discoveryTime[i][j] == -1) { // If not yet visited
                        // Start DFS for a new island
                        findArticulationPoints(
                            grid,
                            i,
                            j,
                            discoveryTime,
                            lowestReachable,
                            parentCell,
                            apInfo
                        )
                        islandCount++
                    }
                }
            }
        }

        // Determine the minimum number of days to disconnect the grid
        if (islandCount == 0 || islandCount >= 2) return 0 // Already disconnected or no land

        if (landCells == 1) return 1 // Only one land cell

        if (apInfo.hasArticulationPoint) return 1 // An articulation point exists

        return 2 // Need to remove any two land cells
    }

    private fun findArticulationPoints(
        grid: Array<IntArray>,
        row: Int,
        col: Int,
        discoveryTime: Array<IntArray>,
        lowestReachable: Array<IntArray>,
        parentCell: Array<IntArray>,
        apInfo: ArticulationPointInfo,
    ) {
        val rows = grid.size
        val cols = grid[0].size
        discoveryTime[row][col] = apInfo.time
        apInfo.time++
        lowestReachable[row][col] = discoveryTime[row][col]
        var children = 0

        // Explore all adjacent cells
        for (direction in DIRECTIONS) {
            val newRow = row + direction[0]
            val newCol = col + direction[1]
            if (isValidLandCell(grid, newRow, newCol)) {
                if (discoveryTime[newRow][newCol] == -1) {
                    children++
                    parentCell[newRow][newCol] = row * cols + col // Set parent
                    findArticulationPoints(
                        grid,
                        newRow,
                        newCol,
                        discoveryTime,
                        lowestReachable,
                        parentCell,
                        apInfo
                    )

                    // Update lowest reachable time
                    lowestReachable[row][col] = min(
                        lowestReachable[row][col].toDouble(),
                        lowestReachable[newRow][newCol].toDouble()
                    ).toInt()

                    // Check for articulation point condition
                    if (lowestReachable[newRow][newCol] >=
                        discoveryTime[row][col] &&
                        parentCell[row][col] != -1
                    ) {
                        apInfo.hasArticulationPoint = true
                    }
                } else if (newRow * cols + newCol != parentCell[row][col]) {
                    // Update lowest reachable time for back edge
                    lowestReachable[row][col] = min(
                        lowestReachable[row][col].toDouble(),
                        discoveryTime[newRow][newCol].toDouble()
                    ).toInt()
                }
            }
        }

        // Root of DFS tree is an articulation point if it has more than one child
        if (parentCell[row][col] == -1 && children > 1) {
            apInfo.hasArticulationPoint = true
        }
    }

    // Check if the given cell is a valid land cell
    private fun isValidLandCell(grid: Array<IntArray>, row: Int, col: Int): Boolean {
        val rows = grid.size
        val cols = grid[0].size
        return (row >= 0 && col >= 0 && row < rows && col < cols && grid[row][col] == 1
                )
    }

    private inner class ArticulationPointInfo(var hasArticulationPoint: Boolean, var time: Int)
    companion object {
        // Directions for adjacent cells: right, down, left, up
        private val DIRECTIONS = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(-1, 0),
        )
    }
}

private fun main() {

}

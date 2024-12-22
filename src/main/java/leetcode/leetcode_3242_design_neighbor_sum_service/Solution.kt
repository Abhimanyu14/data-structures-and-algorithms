package leetcode.leetcode_3242_design_neighbor_sum_service

/**
 * leetcode - https://leetcode.com/problems/design-neighbor-sum-service/
 *
 * Data Structure - Array
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 101 ms, faster than 12.50%
 * Memory Usage: 51.2 MB, less than 25.00%
 *
 * Time - O(N * N)
 * Space - O(N * N)
 */
private class NeighborSum(grid: Array<IntArray>) {
    private val result = mutableMapOf<Int, Pair<Int, Int>>()

    init {
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                var adjacentSum = 0
                var diagonalSum = 0
                if (i > 0) {
                    if (j > 0) {
                        diagonalSum += grid[i - 1][j - 1]
                    }
                    adjacentSum += grid[i - 1][j]
                    if (j < grid[0].lastIndex) {
                        diagonalSum += grid[i - 1][j + 1]
                    }
                }
                if (j > 0) {
                    adjacentSum += grid[i][j - 1]
                }
                if (j < grid[0].lastIndex) {
                    adjacentSum += grid[i][j + 1]
                }
                if (i < grid.lastIndex) {
                    if (j > 0) {
                        diagonalSum += grid[i + 1][j - 1]
                    }
                    adjacentSum += grid[i + 1][j]
                    if (j < grid[0].lastIndex) {
                        diagonalSum += grid[i + 1][j + 1]
                    }
                }
                result[grid[i][j]] = Pair(adjacentSum, diagonalSum)
            }
        }
    }

    fun adjacentSum(value: Int): Int {
        return result.getOrDefault(value, Pair(0, 0)).first
    }

    fun diagonalSum(value: Int): Int {
        return result.getOrDefault(value, Pair(0, 0)).second
    }
}

private fun main() {

}

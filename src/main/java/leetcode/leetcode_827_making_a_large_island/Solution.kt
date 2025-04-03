package leetcode.leetcode_827_making_a_large_island

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/making-a-large-island/?envType=company&envId=facebook&favoriteSlug=facebook-six-months
 *
 * Data Structure - [Array], [IntArray], [Map], [List], [Set]
 * Algorithm - DFS
 *
 * Difficulty - Hard
 *
 * Stats
 * Runtime: 155 ms, faster than 65.31%
 * Memory Usage: 110.20 MB, less than 10.20%
 *
 * Time - O(N ^ 2)
 * Space - O(N ^ 2)
 *
 * Companies - Meta
 */
private fun largestIsland(grid: Array<IntArray>): Int {
    var result = 0
    var islandNumber = 0
    val islandNumbers = Array(grid.size) { IntArray(grid[0].size) }

    fun getIslandSize(x: Int, y: Int): Int {
        islandNumbers[x][y] = islandNumber
        var size = 1
        if (x > 0 && grid[x - 1][y] == 1 && islandNumbers[x - 1][y] == 0) {
            size += getIslandSize(x - 1, y)
        }
        if (y > 0 && grid[x][y - 1] == 1 && islandNumbers[x][y - 1] == 0) {
            size += getIslandSize(x, y - 1)
        }
        if (x < grid.lastIndex && grid[x + 1][y] == 1 && islandNumbers[x + 1][y] == 0) {
            size += getIslandSize(x + 1, y)
        }
        if (y < grid[0].lastIndex && grid[x][y + 1] == 1 && islandNumbers[x][y + 1] == 0) {
            size += getIslandSize(x, y + 1)
        }
        return size
    }

    val islandSize = mutableMapOf<Int, Int>()
    val waterCoordinates = mutableListOf<Pair<Int, Int>>()
    for (i in grid.indices) {
        for (j in grid[0].indices) {
            if (grid[i][j] == 0) {
                waterCoordinates.add(Pair(i, j))
            } else if (islandNumbers[i][j] == 0) {
                islandNumber++
                islandSize[islandNumber] = getIslandSize(i, j)
                result = max(result, islandSize[islandNumber] ?: 0)
            }
        }
    }

    for ((x, y) in waterCoordinates) {
        val islands = mutableSetOf<Int>()
        if (x > 0 && grid[x - 1][y] == 1) {
            islands.add(islandNumbers[x - 1][y])
        }
        if (y > 0 && grid[x][y - 1] == 1) {
            islands.add(islandNumbers[x][y - 1])
        }
        if (x < grid.lastIndex && grid[x + 1][y] == 1) {
            islands.add(islandNumbers[x + 1][y])
        }
        if (y < grid[0].lastIndex && grid[x][y + 1] == 1) {
            islands.add(islandNumbers[x][y + 1])
        }
        var currentSize = 1
        for (island in islands) {
            currentSize += islandSize.getOrDefault(island, 0)
        }
        result = max(result, currentSize)
    }

    return result
}

private fun main() {

}

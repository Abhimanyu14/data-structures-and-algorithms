package leetcode.leetcode_934_shortest_bridge

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/shortest-bridge/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Data Structure - [Array], [BooleanArray], [ArrayDeque] (Queue),
 * Algorithm - BFS (Queue), DFS (Recursion), Input Manipulation
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Google
 */
private fun shortestBridge(grid: Array<IntArray>): Int {
    var result = Int.MAX_VALUE
    val visited = Array(grid.size) {
        BooleanArray(grid[0].size)
    }
    val directions = arrayOf(
        intArrayOf(-1, 0),
        intArrayOf(1, 0),
        intArrayOf(0, -1),
        intArrayOf(0, 1),
    )
    val queue = ArrayDeque<Triple<Int, Int, Int>>()

    fun insideGrid(x: Int, y: Int): Boolean {
        return x >= 0 && x <= grid.lastIndex && y >= 0 && y <= grid[0].lastIndex
    }

    fun dfs(x: Int, y: Int) {
        queue.addLast(Triple(x, y, 0))
        grid[x][y] = 2
        directions.forEach { (x1, y1) ->
            if (insideGrid(x + x1, y + y1) && grid[x + x1][y + y1] == 1) {
                dfs(x + x1, y + y1)
            }
        }
    }

    var foundIsland = false
    for (i in grid.indices) {
        for (j in grid[0].indices) {
            if (grid[i][j] == 1) {
                dfs(i, j)
                foundIsland = true
                break
            }
        }
        if (foundIsland) {
            break
        }
    }

    while (queue.isNotEmpty()) {
        val (x, y, distance) = queue.removeFirst()
        if (visited[x][y]) {
            continue
        }
        visited[x][y] = true
        if (grid[x][y] == 1) {
            result = min(result, distance - 1)
        } else {
            directions.forEach { (x1, y1) ->
                if (insideGrid(x + x1, y + y1) &&
                    !visited[x + x1][y + y1] &&
                    (grid[x + x1][y + y1] == 0 || grid[x + x1][y + y1] == 1)
                ) {
                    queue.addLast(Triple(x + x1, y + y1, distance + 1))
                }
            }
        }
    }
    return result
}

private fun main() {

}

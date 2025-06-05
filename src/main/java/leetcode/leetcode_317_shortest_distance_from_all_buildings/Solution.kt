package leetcode.leetcode_317_shortest_distance_from_all_buildings

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/shortest-distance-from-all-buildings/?envType=company&envId=facebook&favoriteSlug=facebook-three-months
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty - Hard
 *
 * Stats
 *
 * Time - O(M^2 * N^2)
 * Space - O(M * N)
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private fun shortestDistance(grid: Array<IntArray>): Int {
    var result = Int.MAX_VALUE
    val directions = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))

    // Count all houses
    var housesCount = 0
    for (i in grid.indices) {
        for (j in grid[0].indices) {
            if (grid[i][j] == 1) {
                housesCount++
            }
        }
    }

    fun bfs(i: Int, j: Int) {
        val visited = Array(grid.size) {
            BooleanArray(grid[0].size)
        }
        var visitedHouses = 0

        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.addLast(Pair(i, j))
        var dist = 0
        var currentDist = 0
        while (visitedHouses < housesCount && queue.isNotEmpty()) {
            val queueSize = queue.size
            for (m in 0..<queueSize) {
                val (x, y) = queue.removeFirst()
                if (visited[x][y]) {
                    continue
                }
                visited[x][y] = true
                if (grid[x][y] == 1) {
                    visitedHouses++
                    currentDist += dist
                    continue
                }
                directions.forEach {
                    val newX = x + it[0]
                    val newY = y + it[1]
                    if (newX in 0..grid.lastIndex && newY in 0..grid[0].lastIndex && !visited[newX][newY]) {
                        if (grid[newX][newY] == 0 || grid[newX][newY] == 1) {
                            queue.addLast(Pair(newX, newY))
                        }
                    }
                }
            }
            dist++
        }
        if (visitedHouses == housesCount) {
            result = min(result, currentDist)
        }
    }

    for (i in grid.indices) {
        for (j in grid[0].indices) {
            if (grid[i][j] == 0) {
                bfs(i, j)
            }
        }
    }
    return if (result == Int.MAX_VALUE) {
        -1
    } else {
        result
    }
}

private fun main() {

}

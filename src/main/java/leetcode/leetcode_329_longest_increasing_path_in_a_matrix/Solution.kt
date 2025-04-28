package leetcode.leetcode_329_longest_increasing_path_in_a_matrix

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 *
 * Data Structure - [Array], [Map]
 * Algorithm - DFS with DP - memoization
 *
 * Difficulty - Hard
 *
 * Stats
 *
 * Time - O(m * n)
 * Space - O(m * n)
 *
 * Companies - Meta
 */
private fun longestIncreasingPath(matrix: Array<IntArray>): Int {
    val cache = mutableMapOf<Pair<Int, Int>, Int>()
    fun dfs(x: Int, y: Int): Int {
        cache[Pair(x, y)]?.let {
            return it
        }
        var result = 1
        if (x > 0 && matrix[x - 1][y] > matrix[x][y]) {
            result = max(result, 1 + dfs(x - 1, y))
        }
        if (y > 0 && matrix[x][y - 1] > matrix[x][y]) {
            result = max(result, 1 + dfs(x, y - 1))
        }
        if (x < matrix.lastIndex && matrix[x + 1][y] > matrix[x][y]) {
            result = max(result, 1 + dfs(x + 1, y))
        }
        if (y < matrix[0].lastIndex && matrix[x][y + 1] > matrix[x][y]) {
            result = max(result, 1 + dfs(x, y + 1))
        }
        cache[Pair(x, y)] = result
        return result
    }
    var result = 0
    for (i in matrix.indices) {
        for (j in matrix[0].indices) {
            result = max(result, dfs(i, j))
        }
    }
    return result
}

private fun main() {

}

package leetcode.leet_300_to_399.leet_329_longest_increasing_path_in_a_matrix

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 *
 * Using DFS with DP
 *
 * Stats
 * Runtime: 318 ms, faster than 30.95%
 * Memory Usage: 46.1 MB, less than 14.28%
 */
private fun longestIncreasingPath(matrix: Array<IntArray>): Int {
    val rowCount = matrix.size
    val colCount = matrix[0].size

    val memo = Array(rowCount) { IntArray(colCount) { -1 } }
    fun getValidNextNode(x: Int, y: Int): List<Pair<Int, Int>> {
        return buildList {
            if (x - 1 >= 0 && matrix[x][y] < matrix[x - 1][y]) { add(Pair(x - 1, y)) }
            if (y - 1 >= 0 && matrix[x][y] < matrix[x][y - 1]) { add(Pair(x, y - 1)) }
            if (x + 1 < rowCount && matrix[x][y] < matrix[x + 1][y]) { add(Pair(x + 1, y)) }
            if (y + 1 < colCount && matrix[x][y] < matrix[x][y + 1]) { add(Pair(x, y + 1)) }
        }
    }

    fun getLongestPathCount(x: Int, y: Int): Int {
        if (memo[x][y] != -1) {
            return memo[x][y]
        }
        var temp = 1
        getValidNextNode(x, y).forEach {
            temp = max(temp, getLongestPathCount(it.first, it.second) + 1)
        }
        memo[x][y] = temp
        return temp
    }

    var result = 0
    matrix.forEachIndexed { x, row ->
        row.forEachIndexed { y, _ ->
            result = max(result, getLongestPathCount(x, y))
        }
    }
    return result
}

private fun main() {

}

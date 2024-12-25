package leetcode.leetcode_3393_count_paths_with_the_given_xor_value

import java.util.LinkedList

/**
 * leetcode - https://leetcode.com/problems/count-paths-with-the-given-xor-value/
 *
 * TODO - To revisit
 *
 * Data Structure -
 * Algorithm - BFS
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun countPathsWithXorValue(grid: Array<IntArray>, k: Int): Int {
    val dp = Array(grid.size) {
        Array(grid[0].size) {
            IntArray(16) { -1 }
        }
    }

    fun dfs(xorVal: Int, i: Int, j: Int): Int {
        if (i < 0 || j < 0 || j >= grid[0].size || i >= grid.size) {
            return 0
        }
        val xorValCopy = xorVal xor grid[i][j]
        if (dp[i][j][xorValCopy] != -1) {
            return dp[i][j][xorValCopy]
        }
        if (i == grid.lastIndex && j == grid[0].lastIndex && xorValCopy == k) {
            return 1
        }
        val down = dfs(xorValCopy, i + 1, j)
        val right = dfs(xorValCopy, i, j + 1)

        return ((down + right) % 1_000_000_007).also { dp[i][j][xorValCopy] = it }
    }
    return dfs(0, 0, 0)
}

/**
 * leetcode - https://leetcode.com/problems/count-paths-with-the-given-xor-value/
 *
 * Data Structure - Array and Queue
 * Algorithm - BFS
 *
 * Difficulty - Medium
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time -
 * Space -
 */
private fun countPathsWithXorValueUsingBruteForce(grid: Array<IntArray>, k: Int): Int {
    var result = 0
    val mod = 1_000_000_007
    val queue = LinkedList<IntArray>() // 0 - x, 1 - y, 2 - value
    queue.offer(intArrayOf(0, 0, grid[0][0]))
    while (queue.isNotEmpty()) {
        val current = queue.poll()
        if (current[0] == grid.lastIndex && current[1] == grid[0].lastIndex && current[2] == k) {
            result = (result + 1) % mod
        }
        if (current[0] < grid.lastIndex) {
            queue.offer(intArrayOf(current[0] + 1, current[1], current[2] xor grid[current[0] + 1][current[1]]))
        }
        if (current[1] < grid[1].lastIndex) {
            queue.offer(intArrayOf(current[0], current[1] + 1, current[2] xor grid[current[0]][current[1] + 1]))
        }
    }
    return result
}

private fun main() {

}

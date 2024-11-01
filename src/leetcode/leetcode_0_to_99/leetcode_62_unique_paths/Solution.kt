package leetcode.leetcode_0_to_99.leetcode_62_unique_paths

/**
 * leetcode - https://leetcode.com/problems/unique-paths/
 *
 * Using dynamic programming - optimized tabulation
 *
 * Stats
 * Runtime: 133 ms, faster than 93.66%
 * Memory Usage: 32.8 MB, less than 89.18%
 */
private fun uniquePaths(m: Int, n: Int): Int {
    val grid = IntArray(m)
    grid[0] = 1
    repeat(n) {
        for (i in 1 until m) {
            grid[i] = grid[i - 1] + grid[i]
        }
    }
    return grid[m - 1]
}

/**
 * leetcode - https://leetcode.com/problems/unique-paths/
 *
 * Using dynamic programming - tabulation
 *
 * Stats
 * Runtime: 128 ms, faster than 97.39%
 * Memory Usage: 32.9 MB, less than 85.82%
 */
private fun uniquePathsUsingDynamicProgramming(m: Int, n: Int): Int {
    val grid = Array(m) { IntArray(n) }
    grid[m - 1][n - 1] = 1
    for (i in m - 1 downTo 0) {
        for (j in n - 1 downTo 0) {
            if (i != m - 1) {
                grid[i][j] += grid[i + 1][j]
            }
            if (j != n - 1) {
                grid[i][j] += grid[i][j + 1]
            }
        }
    }
    return grid[0][0]
}

/**
 * leetcode - https://leetcode.com/problems/unique-paths/
 *
 * Using backtracking
 *
 * Stats
 * Time Limit Exceeded
 */
private fun uniquePathsUsingBacktracking(m: Int, n: Int): Int {
    var result = 0
    fun backtrack(currentX: Int, currentY: Int, endX: Int, endY: Int) {
        if (currentX == endX && currentY == endY) {
            result++
            return
        }
        if (currentX < endX) {
            backtrack(currentX + 1, currentY, endX, endY)
        }
        if (currentY < endY) {
            backtrack(currentX, currentY + 1, endX, endY)
        }
    }
    backtrack(1, 1, m, n)
    return result
}

private fun main() {
    println(uniquePaths(3, 2))
    println(uniquePaths(3, 7))
    println(uniquePathsUsingBacktracking(1, 1))
}

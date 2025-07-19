package leetcode.leetcode_221_maximal_square

import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/maximal-square/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Data Structure - NA
 * Algorithm - Dynamic Programming
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(M * N)
 * Space - O(M * N)
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private fun maximalSquare(matrix: Array<CharArray>): Int {
    var result = 0
    val m = matrix.size // number of rows
    val n = matrix[0].size // number of columns
    val dp = Array(m) {
        IntArray(n)
    }
    for (i in 0..<m) {
        if (matrix[i][n - 1] == '1') {
            dp[i][n - 1] = 1
            result = 1
        }
    }
    for (i in 0..<n) {
        if (matrix[m - 1][i] == '1') {
            dp[m - 1][i] = 1
            result = 1
        }
    }
    for (i in (m - 2) downTo 0) {
        for (j in (n - 2) downTo 0) {
            if (matrix[i][j] == '0') {
                dp[i][j] = 0
            } else {
                dp[i][j] = minOf(dp[i + 1][j], dp[i + 1][j + 1], dp[i][j + 1]) + 1
                result = max(result, dp[i][j])
            }
        }
    }
    return result * result
}

/**
 * leetcode - https://leetcode.com/problems/maximal-square/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Data Structure - NA
 * Algorithm - Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(M * N * min(M, N))
 * Space - O(1)
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private fun maximalSquareUsingBruteForce(matrix: Array<CharArray>): Int {
    var result = 0
    val maxSize = min(matrix.size, matrix[0].size)
    fun canFormSquare(x: Int, y: Int, size: Int): Boolean {
        if (x + size > matrix.size || y + size > matrix[0].size) {
            return false
        }
        for (i in 0..<size) {
            if (matrix[x + size - 1][y + i] != '1' || matrix[x + i][y + size - 1] != '1') {
                return false
            }
        }
        return true
    }
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            if (matrix[i][j] == '1') {
                for (k in 1..maxSize) {
                    if (canFormSquare(i, j, k)) {
                        result = max(result, k)
                    } else {
                        break
                    }
                }
            }
        }
    }
    return result * result
}

private fun main() {

}

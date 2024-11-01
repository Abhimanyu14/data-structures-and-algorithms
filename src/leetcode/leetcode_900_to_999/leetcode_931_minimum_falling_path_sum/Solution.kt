package leetcode.leetcode_900_to_999.leetcode_931_minimum_falling_path_sum

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/minimum-falling-path-sum/
 *
 * Using
 *
 * Stats
 * Runtime: 223 ms, faster than 100.00%
 * Memory Usage: 38.1 MB, less than 97.83%
 */
fun minFallingPathSum(matrix: Array<IntArray>): Int {
    for (i in 1..matrix.lastIndex) {
        for (j in matrix[i].indices) {
            var value = matrix[i][j] + matrix[i - 1][j]
            if (j - 1 >= 0) {
                value = min(value, matrix[i][j] + matrix[i - 1][j - 1])
            }
            if (j + 1 < matrix[i].size) {
                value = min(value, matrix[i][j] + matrix[i - 1][j + 1])
            }
            matrix[i][j] = value
        }
    }
    var result = matrix[matrix.lastIndex][0]
    for (i in 1..matrix[0].lastIndex) {
        result = min(result, matrix[matrix.lastIndex][i])
    }
    return result
}

private fun main() {

}

package leetcode.leetcode_867_transpose_matrix

/**
 * leetcode - https://leetcode.com/problems/transpose-matrix/
 *
 * Using iteration
 *
 * Stats
 * Runtime: 185 ms, faster than 100.00%
 * Memory Usage: 39.9 MB, less than 17.07%
 */
private fun transpose(matrix: Array<IntArray>): Array<IntArray> {
    val result = Array(matrix[0].size) { IntArray(matrix.size) }
    for (i in matrix.indices) {
        for (j in matrix[0].indices) {
            result[j][i] = matrix[i][j]
        }
    }
    return result
}

private fun main() {

}

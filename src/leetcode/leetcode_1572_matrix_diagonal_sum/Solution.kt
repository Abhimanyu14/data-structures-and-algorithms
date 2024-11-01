package leetcode.leetcode_1572_matrix_diagonal_sum

/**
 * leetcode - https://leetcode.com/problems/matrix-diagonal-sum/
 *
 * Using iteration
 *
 * Stats
 * Runtime: 219 ms, faster than 19.39%
 * Memory Usage: 39.4 MB, less than 46.94%
 */
fun diagonalSum(mat: Array<IntArray>): Int {
    var result = 0
    for (i in mat.indices) {
        result += mat[i][i] + mat[mat.lastIndex - i][i]
    }
    if (mat.size % 2 == 1) {
        result -= mat[mat.size / 2][mat.size / 2]
    }
    return result
}
private fun main() {

}

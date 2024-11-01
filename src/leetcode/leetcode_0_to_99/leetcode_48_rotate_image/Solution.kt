package leetcode.leetcode_0_to_99.leetcode_48_rotate_image

/**
 * leetcode - https://leetcode.com/problems/rotate-image/
 *
 * Using Array transposition and reflection
 *
 * Stats
 * Runtime: 168 ms, faster than 54.05%
 * Memory Usage: 37.8 MB, less than 7.51%
 */
private fun rotate(matrix: Array<IntArray>) {
    for (i in 0..matrix.lastIndex) {
        for (j in (i + 1)..matrix.lastIndex) {
            matrix[i][j] = matrix[j][i].also {
                matrix[j][i] = matrix[i][j]
            }
        }
    }
    for (i in 0..matrix.lastIndex) {
        for (j in 0 until (matrix.size / 2)) {
            matrix[i][j] = matrix[i][matrix.lastIndex - j].also {
                matrix[i][matrix.lastIndex - j] = matrix[i][j]
            }
        }
    }
}

private fun main() {

}

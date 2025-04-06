package leetcode.leetcode_48_rotate_image

/**
 * leetcode - https://leetcode.com/problems/rotate-image/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm - Array transposition & reflection
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 168 ms, faster than 54.05%
 * Memory Usage: 37.8 MB, less than 7.51%
 *
 * Time - O(N^2)
 * Space - O(1)
 *
 * Companies - Meta
 */
private fun rotate(matrix: Array<IntArray>) {
    // Transposition
    for (i in 0..matrix.lastIndex) {
        for (j in (i + 1)..matrix.lastIndex) {
            matrix[i][j] = matrix[j][i].also {
                matrix[j][i] = matrix[i][j]
            }
        }
    }

    // Reflection
    for (i in 0..matrix.lastIndex) {
        for (j in 0..<(matrix.size / 2)) {
            matrix[i][j] = matrix[i][matrix.lastIndex - j].also {
                matrix[i][matrix.lastIndex - j] = matrix[i][j]
            }
        }
    }
}

private fun main() {

}

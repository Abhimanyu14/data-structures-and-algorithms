package leetcode.leet_700_to_799.leet_766_toeplitz_matrix

/**
 * leetcode - https://leetcode.com/problems/toeplitz-matrix/
 *
 * Using iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 209 ms, faster than 16.25%
 * Memory Usage: 40.1 MB, less than 17.50%
 *
 * Time - O(M * N)
 * Space - O(1)
 */
private fun isToeplitzMatrix(matrix: Array<IntArray>): Boolean {
    for (i in 1..matrix.lastIndex) {
        for (j in 1..matrix[0].lastIndex) {
            if (matrix[i][j] != matrix[i - 1][j - 1]) {
                return false
            }
        }
    }
    return true
}

/**
 * leetcode - https://leetcode.com/problems/toeplitz-matrix/
 *
 * Using iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 206 ms, faster than 17.50%
 * Memory Usage: 40.3 MB, less than 15.00%
 *
 * Time - O(M * N)
 * Space - O(1)
 */
private fun isToeplitzMatrixUsingIteration(matrix: Array<IntArray>): Boolean {
    var row: Int
    var col: Int
    var current: Int
    for (i in matrix.indices.reversed()) {
        row = i
        col = 0
        current = matrix[row][col]
        while (row + 1 < matrix.size && col + 1 < matrix[0].size) {
            row++
            col++
            if (matrix[row][col] != current) {
                return false
            }
        }
    }
    for (i in matrix[0].lastIndex downTo 1) {
        row = 0
        col = i
        current = matrix[row][col]
        while (row + 1 < matrix.size && col + 1 < matrix[0].size) {
            row++
            col++
            if (matrix[row][col] != current) {
                return false
            }
        }
    }
    return true
}


private fun main() {

}

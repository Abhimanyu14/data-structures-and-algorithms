package leetcode.leetcode_73_set_matrix_zeroes

/**
 * leetcode - https://leetcode.com/problems/set-matrix-zeroes/
 *
 * Data Structure - NA
 * Algorithm - Input manipulation
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N ^ 2)
 * Space - O(1)
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private fun setZeroes(matrix: Array<IntArray>) {
    var updateFirstCol = false
    var updateFirstRow = false
    for (row in 0..matrix.lastIndex) {
        if (matrix[row][0] == 0) {
            updateFirstCol = true
        }
    }
    for (col in 0..matrix[0].lastIndex) {
        if (matrix[0][col] == 0) {
            updateFirstRow = true
        }
    }
    for (row in matrix.indices) {
        for (col in matrix[0].indices) {
            if (matrix[row][col] == 0) {
                matrix[row][0] = 0
                matrix[0][col] = 0
            }
        }
    }
    for (row in 1..matrix.lastIndex) {
        for (col in 1..matrix[0].lastIndex) {
            if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                matrix[row][col] = 0
            }
        }
    }
    if (updateFirstCol) {
        for (row in 1..matrix.lastIndex) {
            matrix[row][0] = 0
        }
    }
    if (updateFirstRow) {
        for (col in 1..matrix[0].lastIndex) {
            matrix[0][col] = 0
        }
    }
}

/**
 * leetcode - https://leetcode.com/problems/set-matrix-zeroes/
 *
 * Data Structure - [Set]
 * Algorithm - Hashing
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 249 ms, faster than 81.74%
 * Memory Usage: 41.6 MB, less than 62.56%
 *
 * Time - O(N ^ 2)
 * Space - O(M + N)
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private fun setZeroesUsingSet(matrix: Array<IntArray>) {
    val rows = mutableSetOf<Int>()
    val columns = mutableSetOf<Int>()
    matrix.forEachIndexed { rowIndex, row ->
        row.forEachIndexed { colIndex, item ->
            if (item == 0) {
                rows.add(rowIndex)
                columns.add(colIndex)
            }
        }
    }
    matrix.forEachIndexed { rowIndex, row ->
        row.forEachIndexed { colIndex, item ->
            if (item != 0 && (rows.contains(rowIndex) || columns.contains(colIndex))) {
                matrix[rowIndex][colIndex] = 0
            }
        }
    }
}

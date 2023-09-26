package leetcode.leet_0_to_99.leet_73_set_matrix_zeroes

/**
 * leetcode - https://leetcode.com/problems/set-matrix-zeroes/
 *
 * Using loops
 *
 * Stats
 * Runtime: 249 ms, faster than 81.74%
 * Memory Usage: 41.6 MB, less than 62.56%
 */
private fun setZeroes(matrix: Array<IntArray>): Unit {
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

private fun main() {

}

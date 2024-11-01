package leetcode.leetcode_2133_check_if_every_row_and_column_contains_all_numbers

/**
 * leetcode - https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers/
 *
 * Using set
 *
 * Stats
 * Runtime: 441 ms, faster than 16.67%
 * Memory Usage: 45.3 MB, less than 66.67%
 */
private fun checkValid(matrix: Array<IntArray>): Boolean {
    val set = (1..matrix.size).toSet()
    for (i in matrix.indices) {
        if (matrix[i].toSet() != set) {
            return false
        }
    }
    for (i in matrix.indices) {
        val current = mutableSetOf<Int>()
        for (j in matrix.indices) {
            current.add(matrix[j][i])
        }
        if (current != set) {
            return false
        }
    }
    return true
}

private fun main() {

}

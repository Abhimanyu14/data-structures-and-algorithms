package leetcode.leetcode_2400_to_2499.leetcode_2482_difference_between_ones_and_zeros_in_row_and_column

/**
 * leetcode - https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column
 *
 * Using iteration
 *
 * Stats
 * Runtime: 1040 ms, faster than 40.00%
 * Memory Usage: 86.9 MB, less than 40.00%
 */
private fun onesMinusZeros(grid: Array<IntArray>): Array<IntArray> {
    val rowCount = IntArray(grid.size)
    val colCount = IntArray(grid[0].size)
    var current: Int
    for (i in grid.indices) {
        current = 0
        for (j in grid[0].indices) {
            if (grid[i][j] == 1) {
                current++
            }
        }
        rowCount[i] = current
    }
    for (i in grid[0].indices) {
        current = 0
        for (j in grid.indices) {
            if (grid[j][i] == 1) {
                current++
            }
        }
        colCount[i] = current
    }
    val result = Array(grid.size) { IntArray(grid[0].size) }
    for (i in grid.indices) {
        for (j in grid[0].indices) {
            result[i][j] = (2 * rowCount[i]) + (2 * colCount[j]) - (grid.size + grid[0].size)
        }
    }
    return result
}

private fun main() {

}

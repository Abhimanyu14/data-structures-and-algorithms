package leetcode.leet_1200_to_1299.leet_1277_count_square_submatrices_with_all_ones

/**
 * leetcode - https://leetcode.com/problems/count-square-submatrices-with-all-ones/?envType=daily-question&envId=2024-10-27
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun countSquares(matrix: Array<IntArray>): Int {
    var result = 0
    fun isSquare(row: Int, col: Int, size: Int): Boolean {
        if ((row + size > matrix.size) || (col + size > matrix[0].size)) {
            return false
        }
        for (i in 0..<size) {
            if (matrix[row + i][col + size - 1] != 1) {
                return false
            }
            if (matrix[row + size - 1][col + i] != 1) {
                return false
            }
        }
        return true
    }

    var currentSize: Int
    matrix.forEachIndexed { row, items ->
        items.forEachIndexed { col, item ->
            if (item == 1) {
                result++
                currentSize = 2
                while (isSquare(row, col, currentSize)) {
                    result++
                    currentSize++
                }
            }
        }
    }
    return result
}

private fun main() {

}

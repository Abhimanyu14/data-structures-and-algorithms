package leetcode.leetcode_0_to_99.leetcode_74_search_a_2d_matrix

/**
 * leetcode - https://leetcode.com/problems/search-a-2d-matrix/submissions/
 *
 * Using binary search
 *
 * Stats
 * Runtime: 187 ms, faster than 6.35%
 * Memory Usage: 37.1 MB, less than 14.24%
 */
private fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    if (target < matrix[0][0]) {
        return false
    }
    var row = 0
    while (row < matrix.lastIndex && matrix[row + 1][0] <= target) {
        row++
    }
    var low = 0
    var high = matrix[0].lastIndex
    var mid: Int
    while (low <= high) {
        mid = low + ((high - low) / 2)
        if (matrix[row][mid] == target) {
            return true
        } else if (matrix[row][mid] > target) {
            high = mid - 1
        } else {
            low = mid + 1
        }
    }
    return false
}

private fun main() {

}

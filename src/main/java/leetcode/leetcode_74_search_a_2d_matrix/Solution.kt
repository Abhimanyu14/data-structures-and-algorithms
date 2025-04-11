package leetcode.leetcode_74_search_a_2d_matrix

/**
 * leetcode - https://leetcode.com/problems/search-a-2d-matrix/submissions/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm - Two Binary Search
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Meta
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

private fun searchMatrixUsingTwoBinarySearch(matrix: Array<IntArray>, target: Int): Boolean {
    var left = 0
    var right = matrix.size
    while (left < right) {
        val mid = left + (right - left) / 2
        if (matrix[mid][0] > target) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    val row = left - 1
    if (row == -1) {
        return false
    }

    left = 0
    right = matrix[0].size
    while (left < right) {
        val mid = left + (right - left) / 2
        if (matrix[row][mid] > target) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    val col = left - 1
    if (col == -1) {
        return false
    }

    return matrix[row][col] == target
}

private fun main() {

}

package leetcode.leetcode_1901_find_a_peak_element_ii

/**
 * leetcode - https://leetcode.com/problems/find-a-peak-element-ii/description/
 *
 * Data Structure - Two Pointers
 * Algorithm - Binary Search
 *
 * Binary search template - https://leetcode.com/discuss/study-guide/786126/Python-Powerful-Ultimate-Binary-Search-Template.-Solved-many-problems
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 16 ms, faster than 22.22%
 * Memory Usage: 93.9 MB, less than 22.22%
 *
 * Time -
 * Space -
 */
private fun findPeakGrid(mat: Array<IntArray>): IntArray {
    fun getHorizontalPeak(row: Int): Int {
        var left = 0
        var right = mat[0].lastIndex
        while (left < right) {
            val mid = left + ((right - left) / 2)
            if (mat[row][mid] > mat[row][mid + 1]) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left
    }

    fun getVerticalPeak(col: Int): Int {
        var left = 0
        var right = mat.lastIndex
        while (left < right) {
            val mid = left + ((right - left) / 2)
            if (mat[mid][col] > mat[mid + 1][col]) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left
    }

    var row = 0
    var col = 0
    while (true) {
        if (!((row == 0 || mat[row][col] > mat[row - 1][col]) &&
                    (row == mat.lastIndex || mat[row][col] > mat[row + 1][col]))
        ) {
            row = getVerticalPeak(col)
            continue
        }
        if ((col == 0 || mat[row][col] > mat[row][col - 1]) &&
            (col == mat[0].lastIndex || mat[row][col] > mat[row][col + 1])
        ) {
            break
        } else {
            col = getHorizontalPeak(row)
        }
    }
    return intArrayOf(row, col)
}

private fun main() {

}

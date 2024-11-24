package leetcode.leetcode_1975_maximum_matrix_sum

import kotlin.math.abs

/**
 * leetcode - https://leetcode.com/problems/maximum-matrix-sum/
 *
 * TODO(Abhi) - To revisit
 *
 * Using Game Theory
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 11 ms, faster than 100.00%
 * Memory Usage: 56.4 MB, less than 100.00%
 *
 * Time -
 * Space -
 */
private fun maxMatrixSum(matrix: Array<IntArray>): Long {
    var smallestValue = Int.MAX_VALUE
    var hasEvenNegatives = true
    var hasZero = false
    var sum = 0L
    matrix.forEach { row ->
        row.forEach {
            sum += abs(it)
            if (it == 0) {
                hasZero = true
            } else {
                if (it < 0) {
                    hasEvenNegatives = !hasEvenNegatives
                }
                if (abs(it) < smallestValue) {
                    smallestValue = abs(it)
                }
            }
        }
    }
    return if (hasEvenNegatives || hasZero) {
        sum
    } else {
        sum - (smallestValue * 2)
    }
}

private fun main() {

}

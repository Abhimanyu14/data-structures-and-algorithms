package leetcode.leetcode_2579_count_total_number_of_colored_cells

/**
 * leetcode - https://leetcode.com/problems/count-total-number-of-colored-cells/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - NA
 * Algorithm - Pattern
 *
 * Source - https://leetcode.com/problems/count-total-number-of-colored-cells/discuss/3267428/Two-Squares
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 34.3 MB, less than 33.33%
 *
 * Time -
 * Space -
 */
private fun coloredCells(n: Int): Long {
    return (2L * n * n) - (2 * n) + 1
}

/**
 * leetcode - https://leetcode.com/problems/count-total-number-of-colored-cells/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - NA
 * Algorithm - Recursion
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 6 ms, faster than 100.00%
 * Memory Usage: 35.7 MB, less than 33.33%
 *
 * Time -
 * Space -
 */
private fun coloredCellsUsingRecursion(n: Int): Long {
    if (n == 1) {
        return 1
    }
    return (4 * (n - 1)) + coloredCellsUsingRecursion(n - 1)
}

private fun main() {

}

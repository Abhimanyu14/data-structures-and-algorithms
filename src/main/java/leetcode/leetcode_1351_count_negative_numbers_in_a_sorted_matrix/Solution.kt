package leetcode.leetcode_1351_count_negative_numbers_in_a_sorted_matrix

/**
 * leetcode - https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/submissions/
 *
 * Using binary search
 *
 * Binary search template - https://leetcode.com/discuss/study-guide/786126/Python-Powerful-Ultimate-Binary-Search-Template.-Solved-many-problems
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 38.5 MB, less than 58.33%
 *
 * Time -
 * Space -
 */
private fun countNegatives(grid: Array<IntArray>): Int {
    var result = 0
    grid.forEachIndexed { i, row ->
        var left = 0
        var right = row.size
        while (left < right) {
            val mid = left + ((right - left) / 2)
            if (row[mid] < 0) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        result += (row.size - left)
    }
    return result
}

private fun main() {

}
